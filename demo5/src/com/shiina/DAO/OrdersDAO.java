package com.shiina.DAO;

import com.shiina.VO.Orders;

import java.util.Calendar;
import java.util.List;

public interface OrdersDAO {
    // 显示该用户的所有订单信息
    public List<Orders> findAll(String username) throws Exception;

    // 每页显示五条数据（全部订单）
    public List<Orders> findByPage(String username, int start, int rows) throws Exception;

    // 每页显示五条数据（一周内订单）
    public List<Orders> findByPage1(String username, int start, int rows) throws Exception;

    // 增加一条订单信息
    public boolean doCreate(Orders order) throws Exception;

    // 查看一周内的订单信息
    public List<Orders> findByDate(String username) throws Exception;
}
