function showError(e){
    if(e!=null && e!="") {
        $("#message").css("display", "block");
        $("#message").html(e);
    }
}
function checkEmail(e){
    var f = false;
    var error = "";
    if(e!=null && e!=""){
        $.ajax({
            url:"/user/checkEmail.do",
            type:"post",
            dataType:"json",
            data:{
                email:e
            },
            async:false,
            success:function(ret){
                if(ret.flag == "true"){
                    f = true;
                } else{
                    error = ret.message;
                }
            }
        });
    }
    showError(error);
    return f;
}
function checkUserName(n){
    var f = false;
    var error = "";
    if(n!=null && n!=""){
        $.ajax({
            url:"/user/checkUserName.do",
            type:"post",
            dataType:"json",
            data:{
                username:n,
                flag:"register"
            },
            async:false,
            success:function(ret){
                if(ret.flag == "true"){
                    f = true;
                } else{
                    error = ret.message;
                }
            }
        });
    }
    showError(error);
    return f;
}
function checkPwd(p){
    var f = false;
    var error = "";
    if(p==null && p==""){
        error = "请输入密码";
    }else{
        var reP = $("#repassword").val();
        if(reP!=p){
            error = "请重新输入确认密码";
        }else{
            f = true;
        }
    }
    showError(error);
    return f;
}
function checkCaptcher(c){
    var error = "";
    var f = false;
    if(c!=null && c!= ""){
        $.ajax({
            url:"/user/verifyCode.do",
            type:"post",
            dataType:"json",
            data:{
                code:c
            },
            async:false,
            success:function(ret){
                if(ret.flag == "true"){
                    f = true;
                } else{
                    error = ret.message;
                }
            }
        });
    }
    showError(error);
    return f;
}
function changeRegValidataCode(){

}
function doReigster(){
    var error = "";
    var e = false;
    var n = false;
    var p = false;
    var c = false;
    var email = $("#email").val();
    var username = $("#username").val();
    var password = $("#password").val();
    var captcher = $("#regCaptcher").val();
    i = checkUserName(username);
    if(i){
        n = checkPwd(password);
        if(n){
            c = checkCaptcher(captcher);
        }
    }
    if(i && n && c){
        $.ajax({
            url:"/user/doRegister.do",
            type:"post",
            dataType:"json",
            data:{
                email:email,
                username:username,
                password:password
            },
            cache:false,
            success:function(ret){
                if(ret.flag=="true"){
                    window.location = "/pages/user/login.jsp";
                }else{
                    error = ret.message;
                }
            },
            error:function(ret){
                error = "注册失败";
            }
        });
        showError(error);
    }
}