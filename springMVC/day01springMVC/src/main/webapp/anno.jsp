<%--
  Created by IntelliJ IDEA.
  User: mly
  Date: 2019/11/28
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>注解演示页面</title>
</head>
<body>
   <%--常用注解--%>
   <a href="/anno/testRequestParam?username=哈哈">RequestParam</a>


   <%--@RequestBody 注解演示--%>
   <form action="/anno/requestBody" method="post">
       用户名：<input type="text" name="clientName"><br>
       性别：<input type="text" name="sex"><br>
       日期:<input type="date" name="date"><br>
       <input type="submit" value="提交">
   </form>


   <a href="/anno/pathVariable/50">PathVariable</a><br>


   <a href="/anno/requestHeader">requestHeader</a><br>

   <a href="/anno/requestCook">requestCook</a><br>


   <form action="/anno/modelAttribute" method="post">
       用户名：<input type="text" name="clientName"><br>
       性别：<input type="text" name="sex"><br>
       <input type="submit" value="提交">
   </form>

   <a href="/anno/session">savesession</a><br>

   <a href="/anno/getSession">getSession</a><br>

   <a href="/anno/delSession">delSession</a><br>





</body>
</html>
