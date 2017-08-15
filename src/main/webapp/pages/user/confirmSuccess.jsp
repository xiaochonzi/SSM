<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>激活成功</title>
</head>
<body>
<c:choose >
    <c:when test="${sessionScope.user!=null}">
        恭喜， ${sessionScope.user.userName} 已经激活成功！
        <a href="${pageContext.request.contextPath}/welcome">发一条信息炫耀一下</a>
    </c:when>
    <c:otherwise>
        <a href="${pageContext.request.contextPath}/login"></a>
    </c:otherwise>
</c:choose>
</body>
</html>
