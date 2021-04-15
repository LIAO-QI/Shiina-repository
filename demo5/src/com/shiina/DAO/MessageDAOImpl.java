package com.shiina.DAO;

import com.shiina.DB.MySQLConnection;
import com.shiina.VO.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAOImpl implements MessageDAO {

    private Connection conn = null;

    // 这里采用PreparedStatement进行预处理，主要是为了方便SQL注入
    private PreparedStatement pstmt;

    public MessageDAOImpl() throws Exception {
        conn = new MySQLConnection().getConnection();
    }

    @Override
    public List<Message> findAll() throws Exception {
        List<Message> messages = new ArrayList<Message>();
        Message message;
        String sql = "SELECT username,message FROM message";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            ResultSet rs = (ResultSet) this.pstmt.executeQuery();
            while(rs.next()) {
                message = new Message();
                message.setUsername(rs.getString(1));
                message.setMessage(rs.getString(2));
                messages.add(message);
            }
        } catch (SQLException e) {
            throw e;
        }
        this.pstmt.close();
        return messages;
    }

    @Override
    public List<Message> findByPage(int start, int rows) throws Exception {
        List<Message> messages = new ArrayList<Message>();
        Message message;
        String sql = "SELECT * FROM message limit ?,?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setInt(1,start);
            this.pstmt.setInt(2,rows);

            ResultSet rs = (ResultSet) this.pstmt.executeQuery();
            while(rs.next()) {
                message = new Message();
                message.setUsername(rs.getString(1));
                message.setMessage(rs.getString(2));
                messages.add(message);
            }
        } catch (SQLException e) {
            throw e;
        }
        this.pstmt.close();
        return messages;
    }

    @Override
    public boolean doCreate(Message message) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO message(username,message) values ( ? , ? )";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, message.getUsername());
            this.pstmt.setString(2, message.getMessage());

            if(this.pstmt.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            throw e;
        }

        this.pstmt.close();
        return flag;
    }
}
