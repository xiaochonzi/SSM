package com.xiaochonzi.converter;

import com.xiaochonzi.entity.Email;
import com.xiaochonzi.entity.Role;
import com.xiaochonzi.entity.User;
import com.xiaochonzi.service.MailService;
import com.xiaochonzi.service.RoleService;
import com.xiaochonzi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by stone on 17/6/11.
 */
@Controller
@SessionAttributes("user")
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


    @RequestMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,
                        @RequestParam("remember")String remember, Model model){
        User user = new User();
        user.setEmail(email);
        user = userService.selectUserByUser(user);
        if(user!=null && user.verifyPassword(password)){
            model.addAttribute("user",user);
            return "redirect:/welcome";
        }else{
            return "密码错误";
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("email")String email,@RequestParam("username")String username,
                           @RequestParam("password")String password){
        User user = new User();
        user.setEmail(email);
        user.setUserName(username);
        user.gernatePassword(password);
        user.setComfirmed(false);
        user.setMemberSince(new Date());

        Role role = roleService.selectRole(true);
        user.setRole(role);
        int ret = userService.register(user);
        if(ret>0){
            Email e_mail = new Email();
            e_mail.setAddress(email);
            e_mail.setSubject("感谢您注册");
            e_mail.setContent("感谢您注册");
            return "success";
        }else{
            return "error";
        }
    }


}
