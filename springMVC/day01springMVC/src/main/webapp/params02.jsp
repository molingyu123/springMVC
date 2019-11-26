<%--
  Created by IntelliJ IDEA.
  User: mly
  Date: 2019/11/24
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>
   <%--<a href="/param/requestParam?username=hhh">请求参数绑定</a>--%>

   <form action="/param/saveUser" method="post">
       用户名：<input type="text" name="clientName"><br>
       性别：<input type="text" name="sex"><br>
       日期:<input type="date" name="date"><br>
       <input type="submit" value="提交">
   </form>


   <a href="/param/getApi">获取api</a>

</body>
</html>
