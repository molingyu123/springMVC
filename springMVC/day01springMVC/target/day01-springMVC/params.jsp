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
   <a href="/param/requestParam?username=hhh">请求参数绑定</a>

   <form action="/param/saveAccount" method="post">
       姓名:<input type="text" name="username"><br>
       密码:<input type="password" name="password"><br>
       金额:<input type="number" name="money"><br>
       用户名：<input type="text" name="User.clientName"><br>
       性别：<input type="text" name="User.sex"><br>

       用户名：<input type="text" name="list[0].clientName"><br>
       性别：<input type="text" name="list[0].sex"><br>

       用户名：<input type="text" name="map['one'].clientName"><br>
       性别：<input type="text" name="map['one'].sex"><br>
       <input type="submit" value="提交">
   </form>


</body>
</html>
