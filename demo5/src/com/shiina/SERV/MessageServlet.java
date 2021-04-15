package com.shiina.SERV;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiina.UTILS.FindMessageByPage;
import com.shiina.VO.Message;
import com.shiina.VO.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/user/messageServlet")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if (currentPage == null || currentPage.equals("")){
            currentPage = "1";
        }

        if (rows == null || rows.equals("")){
            rows = "5";
        }

        //response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<String,Object>();

        FindMessageByPage fbp ;
        try {
            fbp = new FindMessageByPage();
            // 调用工具类的FindByPage()方法，返回pageBean对象
                PageBean<Message> pb = fbp.findByPage(currentPage,rows);
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
