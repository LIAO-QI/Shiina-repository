package com.shiina.SERV;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiina.UTILS.FindOrdersByPage;
import com.shiina.VO.Orders;
import com.shiina.VO.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/user/ordersServlet")
public class OrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        String user = request.getParameter("user");

        if (currentPage == null || currentPage.equals("")){
            currentPage = "1";
        }

        if (rows == null || rows.equals("")){
            rows = "3";
        }

        //response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<String,Object>();

        FindOrdersByPage fbp ;
        try {
            fbp = new FindOrdersByPage();
            // 调用工具类的FindByPage()方法，返回pageBean对象
            PageBean<Orders> pb = fbp.findByPage(user,currentPage,rows);
            map.put("pb",pb);

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(),map);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
