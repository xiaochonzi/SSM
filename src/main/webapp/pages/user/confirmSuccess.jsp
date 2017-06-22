<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: stone
  Date: 2017/6/22
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>激活成功</title>
</head>
<body>
<c:choose >
    <c:when test="${sessionScope.user!=null}">
        恭喜， ${sessionScope.user.userName} 已经激活成功！
        <a href="${pageContext.request.contextPath}/pages/welcome.jsp">发一条信息炫耀一下</a>
    </c:when>
    <c:otherwise>
        <c:redirect url="${pageContext.request.contextPath}/pages/user/login.jsp"></c:redirect>
    </c:otherwise>
</c:choose>
</body>
</html>
