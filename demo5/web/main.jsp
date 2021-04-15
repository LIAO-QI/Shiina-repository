<%--
  Created by IntelliJ IDEA.
  User: 包子
  Date: 2020/4/24
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiina" uri="http://shiina.com" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="o" uri="/diyoutput" %>
<html>
<head>
    <title>main</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
    <style>

    </style>
</head>
<body>

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
        <div class="card" style="width: 22rem;">
            <img src="b2.jpg" class="card-img-top" alt="..." />
            <ul class="list-group list-group-flush">
                <o:xunhuan items="${map}" key="k" value="v">
                    <c:if test="${k != 'password'}">
                        <li class="list-group-item">
                            <o:shuchu value="${k}"/>：
                            <o:shuchu value="${v}"/>
                        </li>
                    </c:if>
                </o:xunhuan>
            </ul>
            <div class="card-btn">
                <input type="button" value="购物" class="shop-btn">
                <input type="button" value="留言板" class="msgBoard-btn">
                <input type="button" value="修改信息" class="modify-btn">
                <input type="button" value="退出登录" class="quit-btn">
            </div>
        </div>
    </div>
    <shiina:shiina-copyright/>
</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script type="module" src="<c:url value="./js/main.js"></c:url>"></script>
</body>
</html>