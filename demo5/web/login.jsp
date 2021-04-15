<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %><%--
  Created by IntelliJ IDEA.
  User: 包子
  Date: 2020/4/9
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
    <style>
        .drop-table {
            margin-top: 10px;
            margin-left: 10px;
        }

        .dropper {
            outline: 0;
            height: 30px;
            border-radius: 5px;
        }
    </style>
</head>
<%
    //资源包基名
    String basename = "com.shiina.I18N.shiina";

    //获取请求参数
    String lan = request.getParameter("lan");
    if (lan == null) {
        lan = "cn";
    }

    //设置语言环境
    Locale cn = Locale.CHINA;  //中文
    Locale us = Locale.US;     //英文

    //根据基名和语言环境加载对应的语言资源文件
    ResourceBundle myResourcesCN = ResourceBundle.getBundle(basename,cn);   //加载shiina_zh.properties
    ResourceBundle myResourcesUS = ResourceBundle.getBundle(basename,us);   //加载shiina_en.properties

    if (lan.equals("cn")) {
        String login = myResourcesCN.getString("login");
        String usernameTip = myResourcesCN.getString("usernameTip");
        String passwordTip = myResourcesCN.getString("passwordTip");
        String toRegister = myResourcesCN.getString("toRegister");

        request.setAttribute("login",login);
        request.setAttribute("usernameTip",usernameTip);
        request.setAttribute("passwordTip",passwordTip);
        request.setAttribute("toRegister",toRegister);
    }

    if (lan.equals("us")) {
        String login1 = myResourcesUS.getString("login");
        String usernameTip1 = myResourcesUS.getString("usernameTip");
        String passwordTip1 = myResourcesUS.getString("passwordTip");
        String toRegister1 = myResourcesUS.getString("toRegister");

        request.setAttribute("login",login1);
        request.setAttribute("usernameTip",usernameTip1);
        request.setAttribute("passwordTip",passwordTip1);
        request.setAttribute("toRegister",toRegister1);
    }

%>
<body>
<div class="drop-table">
    <select name="drop" class="dropper" id="dropper" onchange="changeLan()">
        <option id="cn" value="cn">中文</option>
        <option id="us" value="us">ENGLISH</option>
    </select>
</div>

<div class="container">
    <!-- login module -->
    <div class="login-box">
        <div id="login-title">
            ${login}
        </div>
        <div class="input">
            <input type="text" id="userName" placeholder="${usernameTip}" name="userName" value="${username}">
        </div>
        <div class="input">
            <input type="password" id="password" placeholder="${passwordTip}" name="password" value="${password}">
        </div>
        <div id="login">
            <input type="button" value="${login}" id="login-btn" />
        </div>
        <div id="register">
            <input type="button" value="${toRegister}" id="to-register-btn" />
        </div>
        <div id="welcome">
            <img src="loading.gif" />
        </div>
    </div>
</div>

<shiina:shiina-copyright/>

<script src="js/jquery-3.2.1.min.js"></script>
<script type="module" src="<c:url value="./js/login.js"></c:url>"></script>
<%--静态资源无法正常加载的bug，原因是在经过servletDispatcher转发时被它内置的过滤器给拦截了。
解决：在jsp页面，引入C标签库，用 <c:url value=""></c:url>标签引入框架文件即可--%>

<script>
    function changeLan() {
        let lan = $("#dropper option:selected").val();

        if (lan == "cn") {
            window.location = "login.jsp?lan=cn";
        }

        if (lan == "us") {
            window.location = "login.jsp?lan=us";
        }
    }

    ((window,document) => {
        let login = $("#login-btn").val();
        let selection = document.getElementById("dropper");
        console.log(login);
        if (login == "Login") {
            // 尝试过：直接通过id取得option来更改selected属性不能成功
            selection.children[1].selected = true;
        }
        if (login == "登录") {
            selection.children[0].selected = true;
        }
    })(window,document);
</script>
</body>
</html>