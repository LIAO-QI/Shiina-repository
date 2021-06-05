package com.shiina.SERV;

import com.shiina.DAO.MessageDAO;
import com.shiina.FACTORY.MessageFactory;
import com.shiina.VO.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/saveMessageServlet")
public class SaveMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 拿到留言板的用户名与留言信息
        String msgBoardUsername = request.getParameter("msgBoardUsername");
        String msgBoardMsg = request.getParameter("msgBoardMsg");

        MessageDAO md = null;
        try {
            md = MessageFactory.getMessageDAOInstance();
            Message msg = new Message();
            msg.setUsername(msgBoardUsername);
            msg.setMessage(msgBoardMsg);
            // 把发言添加进数据库
            md.doCreate(msg);
            response.sendRedirect(request.getContextPath()+"/messageBoard.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
