<%--
  Created by IntelliJ IDEA.
  User: mly
  Date: 2019/12/11
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <h1>hello world</h1>

    <form action="/file/upLoad1" method="post" enctype="multipart/form-data">
       选择文件： <input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>


    <h1>springMvc 文件上传</h1>

    <form action="/file/upLoad2" method="post" enctype="multipart/form-data">
        选择文件： <input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>

    <h1>跨服务器上传</h1>

    <form action="/file/upLoad3" method="post" enctype="multipart/form-data">
        选择文件： <input type="file" name="upload"/><br>
        <input type="submit" value="上传">
    </form>

</body>
</html>
