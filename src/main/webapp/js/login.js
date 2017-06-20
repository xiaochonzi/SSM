/**
 * Created by stone on 17/6/20.
 */
function checkUserName(h,f){
    var i = false;
    var e = ""
    if(h!=null&&h!=""){
     $.ajax({
         url:"/checkUserName",
         type:"post",
         dataType:"json",
         cache:false,
         async:false,
         data:{
             username:f
         },
         success:function(ret){
             if(ret.flag == "true"){
                 i = true;
             }else{
                 e = "用户名不存在";
             }
         },
         error:function(){
             e = "用户名验证失败";
         }
     });
    }else{
        e = "请输入用户名";
    }
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
            url:"/login",
            type:"post",
            dataType:"json",
            data:{
                username:name,
                password:pwd
            },
            cache:false,
            success:function(ret){
                if(ret.flag=="true"){
                    location.href = "/welcome"
                }else{

                }
            },
            error:function(){

            }
        });
    }
}