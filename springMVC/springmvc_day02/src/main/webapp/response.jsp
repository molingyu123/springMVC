<%--
  Created by IntelliJ IDEA.
  User: mly
  Date: 2019/11/29
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    　　<script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        $(function () {
            console.log("1");
            $('#btn').click(function () {
                $.ajax({
                    url:'test/testAjax',
                    contentType:'application/json;charset=UTF-8',
                    type:'post',
                    data:{
                        "username":'aaa',
                        "password":'123',
                        "sex":'aaa'
                    },
                    dataType:'json',
                    success:function (res) {
                        alert(res);
                    },
                    err:function () {
                        alert("err http")
                    }
                })
            });

        })

    </script>
</head>
<body>
   <a href="/test/testString">string test</a><br>

   <a href="/test/testVoid">string void</a><br>

   <a href="/test/testModelAndView">testModelAndView</a><br>

   <a href="/test/testForwardOrRedirect">testForwardOrRedirect</a><br>

  <button id="btn">ajaxTest</button>

</body>
</html>
