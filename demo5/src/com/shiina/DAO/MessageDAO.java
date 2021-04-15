package com.shiina.DAO;

import com.shiina.VO.Message;

import java.util.List;

public interface MessageDAO {
    // 显示所有信息
    public List<Message> findAll() throws Exception;

    // 每页显示五条数据
    public List<Message> findByPage(int start, int rows) throws Exception;

    // 增加一条信息
    public boolean doCreate(Message message) throws Exception;
}
