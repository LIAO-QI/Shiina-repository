<%--
  Created by IntelliJ IDEA.
  User: 包子
  Date: 2020/6/3
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <style>
        body {
            width: 100%;
            height: 100%;
            background-image: linear-gradient(150deg, #33b0a6,#fb5f21);
            overflow: hidden;
        }

        .indexToLogin {
            width: 600px;
            height: 350px;
            position: absolute;
            left: 50%;
            top: 50%;
            transform: translate(-50%,-50%);
            background-color: rgba(0, 0, 0, .7);
            border-radius: 20px;
            box-shadow: 0px 0px 20px rgba(17, 39, 59, .8);
            box-sizing: border-box;
            overflow: hidden;
        }

        .indexToLogin a {
            text-decoration: none;
            font-size: 50px;
            color: white;
            text-shadow: 0 0 20px #33B0A6;
            display: block;
            text-align: center;
            margin-top: 130px;
        }
    </style>
</head>
<body>
    <div class="indexToLogin"><a href="login.jsp?lan=cn">去登录</a></div>
</body>
</html>
