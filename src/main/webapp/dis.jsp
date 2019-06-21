<%--
  Created by IntelliJ IDEA.
  User: ZeDongW
  Date: 2019/6/21 0021
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>无效字符过滤</title>
    <script src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ckeditor/samples/sample.css">
</head>
<body>
    ${requestScope.content }
    <form name="frmDis" action="${pageContext.request.contextPath}/dis" method="post">
        发表评论: <textarea class="ckeditor" rows="6" cols="30" name="content"></textarea>
        <br/>
        <input type="submit" value="评论" >
    </form>

</body>
</html>
