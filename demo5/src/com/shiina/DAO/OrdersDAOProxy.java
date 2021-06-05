package com.shiina.DAO;

import com.shiina.VO.Orders;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAOProxy implements OrdersDAO {
    private OrdersDAO dao;

    public OrdersDAOProxy() throws Exception {
        this.dao = new OrdersDAOImpl();
    }

    @Override
    public List<Orders> findAll(String username) throws Exception {
        List<Orders> orders = new ArrayList<Orders>();
        try {
            orders = this.dao.findAll(username);
        }catch(Exception e) {
            throw e;
        }finally {
            //this.conn.close();
        }
        return orders;
    }

    @Override
    public List<Orders> findByPage(String username, int start, int rows) throws Exception {
        List<Orders> orders = new ArrayList<Orders>();
        try {
            orders = this.dao.findByPage(username,start,rows);
        }catch(Exception e) {
            throw e;
        }finally {
            //this.conn.close();
        }
        return orders;
    }

    @Override
    public List<Orders> findByPage1(String username, int start, int rows) throws Exception {
        List<Orders> orders = new ArrayList<Orders>();
        try {
            orders = this.dao.findByPage1(username,start,rows);
        }catch(Exception e) {
            throw e;
        }finally {
            //this.conn.close();
        }
        return orders;
    }

    @Override
    public boolean doCreate(Orders order) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.doCreate(order);
        }catch(Exception e) {
            throw e;
        }finally {
            //this.conn.close();
        }
        return flag;
    }

    @Override
    public List<Orders> findByDate(String username) throws Exception {
        List<Orders> orders = new ArrayList<Orders>();
        try {
            orders = this.dao.findByDate(username);
        }catch(Exception e) {
            throw e;
        }finally {
            //this.conn.close();
        }
        return orders;
    }
}
