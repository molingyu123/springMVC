<%--
  Created by IntelliJ IDEA.
  User: mly
  Date: 2019/12/19
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello world</title>
</head>
<body>
 <h3>加载ok....</h3>

 <a href="test/findAll">测试</a>

<h3>保存</h3>
<form action="test/save" method="post">
    姓名:<input type="text" name="name"><br>
    金额:<input type="text" name="money">
    <input type="submit" value="保存">
</form>

</body>
</html>
