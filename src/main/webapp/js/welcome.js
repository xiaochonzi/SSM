/**
 * Created by stone on 17/8/14.
 */
function logout(){
    $.ajax({
        url:"/user/logout",
        dataType:"json",
        success:function(ret){
            if(ret.result){
                window.location.href = '/';
            }else{
                window.location.reload();
            }
        }
    });
}
