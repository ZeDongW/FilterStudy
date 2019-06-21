<%--
  Created by IntelliJ IDEA.
  User: ZeDongW
  Date: 2019/6/21 0021
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title>编码处理</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/encoding" method="post">
    <input type="text" name="userName"/>
    <input type="submit" value="post提交"/>
</form>
<form action="${pageContext.request.contextPath}/encoding" method="get">
    <input type="text" name="userName"/>
    <input type="submit" value="get提交"/>
</form>
</body>
</html>
