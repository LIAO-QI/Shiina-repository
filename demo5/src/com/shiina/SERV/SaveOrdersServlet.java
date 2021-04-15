package com.shiina.SERV;

import com.shiina.DAO.GoodsDAO;
import com.shiina.DAO.OrdersDAO;
import com.shiina.FACTORY.GoodsFactory;
import com.shiina.FACTORY.OrdersFactory;
import com.shiina.VO.Goods;
import com.shiina.VO.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(urlPatterns = "/user/saveOrdersServlet")
public class SaveOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户选中的商品id以及用户者
        String goodsArray = request.getParameter("goodsArray");
        String user = request.getParameter("user");

        // 字符串转化为String数组
        String[] goodsList;
        goodsList = goodsArray.split(",");

        // 日期格式化（下单时间）
        Date time = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(time);

        OrdersDAO od = null;
        Orders order;
        GoodsDAO gd = null;
        try {
            od = OrdersFactory.getOrdersDAOInstance();
            gd = GoodsFactory.getGoodsDAOInstance();

            for (int i=0;i<goodsList.length;i++){
                int id = Integer.parseInt(goodsList[i]);
                Goods goods = gd.findByID(id);

                // 把订单信息封装成一个Orders对象
                order = new Orders();
                order.setUsername(user);
                order.setTime(currentTime);
                order.setId(goods.getId());
                order.setGoodsName(goods.getGoodsName());
                order.setGoodsPrice(goods.getGoodsPrice());
                order.setGoodsImage(goods.getGoodsImage());

                // 把订单信息添加进数据库
                od.doCreate(order);
            }

            response.sendRedirect(request.getContextPath()+"/orders.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}