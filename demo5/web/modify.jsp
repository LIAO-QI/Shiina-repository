<%--
  Created by IntelliJ IDEA.
  User: 包子
  Date: 2020/4/27
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiina" uri="http://shiina.com" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="o" uri="/diyoutput" %>
<html>
<head>
    <title>modify</title>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css">
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
                    <c:if test="${k == 'username'}">
                        <li class="list-group-item">
                            <o:shuchu value="${k}"/>：
                            <input type="text" value="${v}" id="${k}" readonly="readonly">
                        </li>
                    </c:if>
                    <c:if test="${k != 'username'}">
                        <li class="list-group-item">
                            <o:shuchu value="${k}"/>：
                            <input type="text" value="${v}" id="${k}" contenteditable="true">
                        </li>
                    </c:if>
                </o:xunhuan>
            </ul>
            <div class="card-btn">
                <div class="m1">
                    <input type="button" value="提交修改" class="confirm-modify-btn">
                </div>
                <div class="m2">
                    <input type="button" value="返回主页" class="to-main-btn">
                </div>
            </div>
        </div>
    </div>
    <shiina:shiina-copyright/>
</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script type="module" src="<c:url value="./js/modify.js"></c:url>"></script>
</body>
</html>