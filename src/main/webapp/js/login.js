/**
 * Created by stone on 17/6/20.
 */
function checkUserName(h,f){
    var i = false;
    var e = ""
    if(h!=null&&h!=""){
     $.ajax({
         url:"/user/checkUserName.do",
         type:"post",
         dataType:"json",
         cache:false,
         async:false,
         data:{
             username:h
         },
         success:function(ret){
             if(ret.flag == "true"){
                 i = true;
             }else{
                 e = ret.message;
             }
         },
         error:function(){
             e = "用户名验证失败";
         }
     });
    }else{
        e = "请输入用户名";
    }
    $("#nametan").css("display","block");
    $("#nametan").html(e);
    return i;
}
function checkPwd(d) {
    var i = false;
    var e = "";
    if(d!=null && d!=""){
        i = true;
    }else{
        e = "请输入密码"
    };
    return i;
}
function doLogin(){
    var error = "";
    var l = false;
    var m = false;
    var i = false;
    var name = $("#username").val()
    var pwd = $("#password").val()
    var remember = $("#cbkRember").val()
    l = checkUserName(name);
    if(l){
        m = checkPwd(pwd)
    }
    if(l && m){
        $.ajax({
            url:"/user/doLogin.do",
            type:"post",
            dataType:"json",
            data:{
                username:name,
                password:pwd,
                remember:remember
            },
            cache:false,
            success:function(ret){
                if(ret.flag=="true"){
                    location.href = "/welcome"
                }else{
                    error = ret.message;
                }
            },
            error:function(){
                error = "登录失败！";
            }
        });
    }
    if(error!=""){
        console.log(error);
    }
}