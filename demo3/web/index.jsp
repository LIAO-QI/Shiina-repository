<%--
  Created by IntelliJ IDEA.
  User: 包子
  Date: 2020/4/9
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiina" uri="http://shiina.com" %>
<%--<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>--%>
<html>
<head>
    <title>login</title>
    <link href="css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="container">

    <!-- login module -->
    <div class="login-box">
        <div id="login-title">
            Login
        </div>

        <div class="input">
            <input type="text" id="userName" placeholder="Input your userName" name="userName" value="${username}">
        </div>
        <div class="input">
            <input type="password" id="password" placeholder="Input your password" name="password" value="${password}">
        </div>

        <div id="login">
            <input type="button" value="Login" id="login-btn" />
        </div>

        <div id="register">
            <input type="button" value="To Register" id="to-register-btn" />
        </div>

        <div id="welcome">
            <img src="https://www.shiinaliu.com/pic/loading.gif" />
        </div>
    </div>

</div>

<shiina:shiina-copyright/>

<script src="js/jquery-3.2.1.min.js"></script>
<script type="module" src="<c:url value="./js/login.js"></c:url>"></script>
<%--静态资源无法正常加载的bug，原因是在经过servletDispatcher转发时被它内置的过滤器给拦截了。
解决：在jsp页面，引入C标签库，用 <c:url value=""></c:url>标签引入框架文件即可--%>
</body>
</html>