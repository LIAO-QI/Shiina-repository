package com.shiina.SERV;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiina.DAO.UserDAO;
import com.shiina.FACTORY.UserFactory;
import com.shiina.VO.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/user/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取前端请求数据
        String username1 = request.getParameter("username1");
        String password1 = request.getParameter("password1");

        //response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<String,Object>();

        UserDAO ud = null;
        try {
            ud = UserFactory.getUserDAOInstance();
            User user = ud.findByUsername(username1);
            // 判断用户名是否存在
            if (user.getUsername() != null) {
                map.put("registerFlag", false);
                map.put("dbFlag",false);
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getWriter(),map);
            } else {
                // 用户名不存在，封装成user对象，可注册写进数据库里
                User u = new User();
                u.setUsername(username1);
                u.setPassword(password1);
                boolean dbFlag = ud.doCreate(u);

                if (dbFlag) {
                    map.put("registerFlag",true);
                    map.put("dbFlag",true);
                    map.put("user",u);
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.writeValue(response.getWriter(),map);
                } else {
                    map.put("registerFlag",true);
                    map.put("dbFlag",false);
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.writeValue(response.getWriter(),map);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
