package com.shiina.SERV;

import org.apache.taglibs.standard.extra.spath.Step;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/registerToLoginServlet")
public class RegisterToLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 拿到注册的账号密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 把账号密码存在session里，本次会话期间有效
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("password",password);

        // 重定向回登录页，即可通过el表达式拿到注册的账号密码，自动填满，不必重新输入
        // el表达式有容错性，一开始启动服务器时虽然拿不到任何东西，但也不会报错
        response.sendRedirect(request.getContextPath()+"/index.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}