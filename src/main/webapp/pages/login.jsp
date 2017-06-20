<%--
  Created by IntelliJ IDEA.
  User: stone
  Date: 17/6/18
  Time: 下午11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
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
                        <input type="text" id="password" name="password"> &nbsp;&nbsp;<a href="">忘记密码？</a>
                        <br/>
                        <div id="pwdtan" style="display: none;"></div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="checkbox" id="cbkRember" name="remember"><label>记住密码</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="button" id="loginBtn" onclick="doLogin();">
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div id="footer"></div>
</body>
</html>
