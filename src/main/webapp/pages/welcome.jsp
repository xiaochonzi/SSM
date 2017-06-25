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
    <title>首页</title>
</head>
<body>
<div>
    <ul>
        <li>您好，欢迎登陆惊叹号！</li>
        <li>
            <a href="${pageContext.request.contextPath}/user/userInfo.do?userId=${user.id}"></a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/user/logout.do"></a>
        </li>
    </ul>
</div>
</body>
</html>
