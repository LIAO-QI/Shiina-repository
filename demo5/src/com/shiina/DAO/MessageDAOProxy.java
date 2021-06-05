package com.shiina.DAO;

import com.shiina.VO.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageDAOProxy implements MessageDAO {
    private MessageDAO dao;

    public MessageDAOProxy() throws Exception {
        this.dao = new MessageDAOImpl();
    }

    @Override
    public List<Message> findAll() throws Exception {
        List<Message> messages = new ArrayList<Message>();
        try {
            messages = this.dao.findAll();
        }catch(Exception e) {
            throw e;
        }finally {
            //this.conn.close();
        }
        return messages;
    }

    @Override
    public List<Message> findByPage(int start, int rows) throws Exception {
        List<Message> messages = new ArrayList<Message>();
        try {
            messages = this.dao.findByPage(start,rows);
        }catch(Exception e) {
            throw e;
        }finally {
            //this.conn.close();
        }
        return messages;
    }

    @Override
    public boolean doCreate(Message message) throws Exception {
        boolean flag = false;
        try {
            flag = this.dao.doCreate(message);
        }catch(Exception e) {
            throw e;
        }finally {
            //this.conn.close();
        }
        return flag;
    }
}
