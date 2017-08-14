<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/plugins/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/welcome.js"></script>
</head>
<body>
<div>
    <ul>
        <li>您好，欢迎登陆惊叹号！</li>
        <li>
            <a href="${pageContext.request.contextPath}/user/userInfo?userId=${user.id}"></a>
        </li>
        <li>
            <a href="javascript:logout();"></a>
        </li>
    </ul>
</div>
<div id="content">
   <div id="editPost">

   </div>
    <div id="postContent">
        <ul>
        <c:forEach var="post" items="${userDetail.posts}">
            <li>${post.body}</li>
        </c:forEach>
        </ul>
    </div>
</div>
<div class="footer">

</div>
</body>
</html>
