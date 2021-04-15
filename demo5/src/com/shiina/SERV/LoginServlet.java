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

@WebServlet(urlPatterns = "/user/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取前端请求数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //response.setContentType("application/json;charset=utf-8");  //需要接收json这样的编码格式才能登录成功
        Map<String,Object> map = new HashMap<String,Object>();

        UserDAO ud = null;
        try {
            ud = UserFactory.getUserDAOInstance();
            User user = ud.findByUsername(username);
            // 判断用户名是否存在
            if (user.getUsername() == null) {
                map.put("userFlag", false);
                map.put("loginFlag",false);
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getWriter(),map);
            } else {
                // 判断密码是否正确
                if (!user.getPassword().equals(password)) {
                    map.put("userFlag",true);
                    map.put("loginFlag",false);
                    ObjectMapper mapper = new ObjectMapper();
                    mapper.writeValue(response.getWriter(),map);
                } else {
                    map.put("userFlag",true);
                    map.put("loginFlag",true);
                    map.put("user",user);
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
