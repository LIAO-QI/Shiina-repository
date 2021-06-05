package com.shiina.FACTORY;

import com.shiina.DAO.OrdersDAO;
import com.shiina.DAO.OrdersDAOProxy;

public class OrdersFactory {
    // 静态方法,返回值类型为Dao接口类型,实际返回Dao的实现类
    public static OrdersDAO getOrdersDAOInstance() throws Exception {
        return new OrdersDAOProxy();
    }
}
