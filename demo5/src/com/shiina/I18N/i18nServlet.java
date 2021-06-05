package com.shiina.I18N;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = "/i18nServlet")
public class i18nServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //资源包基名
        String basename = "com.shiina.I18N.shiina";
        //获取session
        HttpSession session = request.getSession();

        //获取请求参数
        String lan = request.getParameter("lan");
        if (lan == null) {
            lan = "cn";
        }

        //设置语言环境
        Locale cn = Locale.CHINA;  //中文
        Locale us = Locale.US;     //英文

        //根据基名和语言环境加载对应的语言资源文件
        ResourceBundle myResourcesCN = ResourceBundle.getBundle(basename,cn);//加载shiina_zh.properties
        ResourceBundle myResourcesUS = ResourceBundle.getBundle(basename,us);//加载shiina_en.properties

        //加载资源文件后， 程序就可以调用ResourceBundle实例对象的 getString方法获取指定的资源信息名称所对应的值。
        if (lan.equals("cn")) {
            //存入session重定向回登录页
            if (session.getAttribute("login")!=null) {
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            } else {
                String login = myResourcesCN.getString("login");
                String usernameTip = myResourcesCN.getString("usernameTip");
                String passwordTip = myResourcesCN.getString("passwordTip");
                String toRegister = myResourcesCN.getString("toRegister");

                session.setAttribute("login",login);
                session.setAttribute("usernameTip",usernameTip);
                session.setAttribute("passwordTip",passwordTip);
                session.setAttribute("toRegister",toRegister);
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
        }

        if (lan.equals("us")) {
            //存入session重定向回登录页
            if (session.getAttribute("login1")!=null) {
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            } else {
                String login1 = myResourcesUS.getString("login");
                String usernameTip1 = myResourcesUS.getString("usernameTip");
                String passwordTip1 = myResourcesUS.getString("passwordTip");
                String toRegister1 = myResourcesUS.getString("toRegister");

                //存入session重定向回登录页
                session.setAttribute("login", login1);
                session.setAttribute("usernameTip", usernameTip1);
                session.setAttribute("passwordTip", passwordTip1);
                session.setAttribute("toRegister", toRegister1);
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
