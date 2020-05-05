<%--
  Created by IntelliJ IDEA.
  User: 包子
  Date: 2020/4/27
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiina" uri="http://shiina.com" %>
<html>
<head>
    <title>doModify</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
    <style>
        #relogin {
            background-color: inherit;
            border: 0;
            outline: 0;
            position: absolute;
            left: 50%;
            transform: translateX(-50%);
            margin-top: 10px;
            font-size: 20px;
        }

        #relogin:hover {
            color: #33b0a6;
            transition: color .2s;
        }
    </style>
</head>
<body>
<%--要用el表达式取值，必须事先把值存入任意一个jsp的内置对象中，否则将拿不到。--%>

<div id="root">
    <div id="top"></div>
    <div id="bottom" class="container">
        <div class="bubbles">
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
        </div>

        <div style="margin-top: 100px;border: 2px dashed black; padding: 20px">
            <h3>修改前信息：</h3>
            ${map}<hr>

            <h3>修改后信息：</h3>
            <jsp:useBean id="user" class="com.shiina.VO.User" scope="request"></jsp:useBean>

            <jsp:setProperty name="user" property="password" value="${userModify.password}" />
            <jsp:setProperty name="user" property="sex" value="${userModify.sex}" />
            <jsp:setProperty name="user" property="name" value="${userModify.name}" />
            <jsp:setProperty name="user" property="age" value="${userModify.age}" />
            <jsp:setProperty name="user" property="username" value="${userModify.username}" />

            password： <jsp:getProperty name="user" property="password"/><br>
            sex：<jsp:getProperty name="user" property="sex"/><br>
            name：<jsp:getProperty name="user" property="name"/><br>
            age：<jsp:getProperty name="user" property="age"/><br>
            username：<jsp:getProperty name="user" property="username"/>
        </div>

        <input type="button" value="重新登陆" id="relogin" onclick="window.location = 'index.jsp'"/>

        <shiina:shiina-copyright/>
</div>

</body>
</html>