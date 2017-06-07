<%--
  Created by IntelliJ IDEA.
  User: stone
  Date: 17/6/6
  Time: 下午11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>上传文件</h2>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传文件">
</form>
</body>
</html>
