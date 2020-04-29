<%--
  Created by IntelliJ IDEA.
  User: 包子
  Date: 2020/4/27
  Time: 0:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiina" uri="http://shiina.com" %>
<html>
<head>
    <title>register</title>
    <link href="css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="container">

    <!-- register module -->
    <div class="register-box">
        <div id="register-title">
            Register
        </div>

        <div class="input">
            <input type="text" id="userName-1" placeholder="Create your userName" name="userName-1">
        </div>
        <div class="input">
            <input type="password" id="password-1" placeholder="Create your password" name="password-1">
        </div>

        <div id="register-1">
            <input type="button" value="Register" id="register-btn" />
        </div>

        <div id="login-1">
            <input type="button" value="To Login" id="to-login-btn" />
        </div>

        <div id="welcome-1">
            <img src="https://www.shiinaliu.com/pic/loading.gif" />
        </div>
    </div>

</div>

<shiina:shiina-copyright/>

<script src="js/jquery-3.2.1.min.js"></script>
<script type="module" src="<c:url value="./js/register.js"></c:url>"></script>
</body>
</html>