package com.xiaochonzi.controller;

import com.xiaochonzi.entity.Email;
import com.xiaochonzi.entity.JsonResult;
import com.xiaochonzi.entity.Role;
import com.xiaochonzi.entity.User;
import com.xiaochonzi.service.MailService;
import com.xiaochonzi.service.RoleService;
import com.xiaochonzi.service.UserService;
import com.xiaochonzi.util.Captcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stone on 17/6/11.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    @Autowired
    @Qualifier("mailer")
    private MailService mailService;


    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(@RequestParam("username") String username, @RequestParam("password") String password,
                        @RequestParam("remember")String remember,HttpServletResponse response,HttpSession session){
        JsonResult result = new JsonResult();
        User user = new User();
        user.setUserName(username);
        user = userService.selectUserByUser(user);
        if(user!=null && user.verifyPassword(password)){
            user.setLastSeen(new Date());
            userService.updateUser(user);
            session.setAttribute("user",user);
            if("Y".equals(remember)){
                Cookie cookie = new Cookie("userId",String.valueOf(user.getId()));
                response.addCookie(cookie);
            }
            result.setFlag("true");
        }else{
            result.setFlag("false");
            result.setMessage("用户名或密码错误");
        }
        return result;
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public JsonResult register(@RequestParam("email")String email,@RequestParam("username")String username,
                           @RequestParam("password")String password,HttpSession session,JsonResult result) throws MessagingException {
        User user = new User();
        user.setEmail(email);
        user.setUserName(username);
        user.gernatePassword(password);
        user.setConfirmed(false);
        user.setMemberSince(new Date());

        Role role = roleService.selectRoleByDefault(true);
        user.setRole(role);
        int ret = userService.register(user);
        if(ret>0){
            session.setAttribute("user",user);
            Email e_mail = new Email();
            e_mail.setAddress(email);
            e_mail.setSubject("感谢您注册");
            String token = user.generateConfirmToken();
            Map model = new HashMap();
            model.put("user",user);
            model.put("token",token);
            e_mail.setModel(model);
            mailService.sendMail(e_mail);
            result.setFlag("true");
            result.setMessage("注册成功");
        }else{
            result.setFlag("false");
            result.setMessage("注册失败！");
        }
        return result;
    }

    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkEmail(@RequestParam("email")String email,JsonResult result){
        User user = new User();
        user.setEmail(email);
        user = userService.selectUserByUser(user);
        if(user!=null){
            result.setFlag("false");
            result.setMessage("邮箱已经被使用！");
        }else{
            result.setFlag("true");
        }
        return result;
    }

    @RequestMapping(value = "/checkUserName", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkUserName(@RequestParam("username")String username,@RequestParam("flag")String flag,JsonResult result){
        User user = new User();
        user.setUserName(username);
        user = userService.selectUserByUser(user);
        if("register".equals(flag)){
            if(user==null){
                result.setFlag("true");
            }else{
                result.setFlag("false");
                result.setMessage("用户已存在");
            }
        }else if("login".equals(flag)){
            if(user!=null){
                result.setFlag("true");
            }else{
                result.setFlag("false");
                result.setMessage("用户不存在");
            }
        }
        return result;
    }

    @RequestMapping(value = "/verifyCode", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult verifyCode(@RequestParam("code")String code,HttpSession session,JsonResult result){
        String sessionCode = (String)session.getAttribute("code");
        if(sessionCode!=null && code.toLowerCase().equals(sessionCode.toLowerCase())){
            result.setFlag("true");
        }else{
            result.setFlag("false");
            result.setMessage("验证码不匹配！");
        }
        return result;
    }

    @RequestMapping(value = "/dverifyCode",method = RequestMethod.GET)
    public void dverifyCode(HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        Captcher captcher = new Captcher(85,35);
        String code = captcher.getCode();
        session.setAttribute("code",code);
        captcher.write(response.getOutputStream());
        response.getOutputStream().close();
    }


    @RequestMapping("/confirm/{token}")
    public String confirm(@PathVariable("token")String token, Model m) throws IOException {
        Map model = User.confirm(token);
        Integer id = (Integer) model.get("id");
        Long expiration = (Long) model.get("expiration");
        if(expiration>=System.currentTimeMillis()){
            User user = new User();
            user.setId(id);
            user.setConfirmed(true);
            userService.updateUser(user);
            return "user/confirmSuccess";
        }else{
            m.addAttribute("message","链接失效");
            return null;
        }
    }

}
