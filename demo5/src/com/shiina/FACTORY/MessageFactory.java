package com.shiina.FACTORY;

import com.shiina.DAO.MessageDAO;
import com.shiina.DAO.MessageDAOProxy;

public class MessageFactory {
    // 静态方法,返回值类型为Dao接口类型,实际返回Dao的实现类
    public static MessageDAO getMessageDAOInstance() throws Exception {
        return new MessageDAOProxy();
    }
}
