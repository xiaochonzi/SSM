<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/user/register.js"></script>
</head>
<body>
<div id="header"></div>
<div id="content">
    <div>
        <table>
            <tr>
                <td>
                    <div id="message" style="display: none;"></div>
                </td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td>
                    <input type="email" id="email" name="email" placeholder="请输入邮箱">
                </td>
            </tr>
            <tr>
                <td>用户名</td>
                <td>
                    <input type="text" id="username" name="username" placeholder="请输入用户名">
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="password" id="password" name="password" placeholder="请输入密码">
                </td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td>
                    <input type="password" id="repassword" name="repassword" placeholder="请输入确认密码">
                </td>
            </tr>
            <tr>
                <td>验证码</td>
                <td>
                    <input type="text" id="regCaptcher" name="regCaptcher">
                    <a>
                        <img src="${pageContext.request.contextPath}/user/dverifyCode?t=<%=new Date().getTime()%>" id="regCaptcherImg">
                    </a>
                    <a href="javascript:changeRegValidataCode();">换一张</a>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="button" id="registerBtn" value="注册" onclick="doReigster();">
                </td>
            </tr>
        </table>
    </div>
</div>
<div id="footer"></div>
</body>
</html>
