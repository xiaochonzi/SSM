<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user/login.js"></script>
</head>
<body>
<div id="header"></div>
<div id="content">
    <div id="left"></div>
    <div id="right">
        <div>
            <table>
                <tr>
                    <td>
                        <input type="text" id="username" name="username" placeholder="请输入邮箱或者用户名" autocomplete="off">
                        <br/>
                        <div id="nametan" style="display: none;"></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="password" id="password" name="password" placeholder="请输入密码" autocomplete="off"> &nbsp;&nbsp;<a href="#">忘记密码？</a>
                        <br/>
                        <div id="pwdtan" style="display: none;"></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" id="cbkRember" name="remember" value="Y"><label>记住密码</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="button" id="loginBtn" onclick="doLogin();" value="登录"/>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div id="footer"></div>
</body>
</html>
