package com.shiina.DAO;

import com.shiina.DB.MySQLConnection;
import com.shiina.VO.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {

    private Connection conn = null;

    // 这里采用PreparedStatement进行预处理，主要是为了方便SQL注入
    private PreparedStatement pstmt;

    public OrdersDAOImpl() throws Exception {
        conn = new MySQLConnection().getConnection();
    }

    @Override
    public List<Orders> findAll(String username) throws Exception {
        List<Orders> orders = new ArrayList<Orders>();
        Orders order;
        String sql = "SELECT * FROM orders where username=?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,username);
            ResultSet rs = (ResultSet) this.pstmt.executeQuery();
            while(rs.next()) {
                order = new Orders();
                order.setId(rs.getInt(3));
                order.setGoodsName(rs.getString(4));
                order.setGoodsPrice(rs.getDouble(5));
                order.setGoodsImage(rs.getString(6));
                order.setTime(rs.getString(2));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw e;
        }
        this.pstmt.close();
        return orders;
    }

    @Override
    public List<Orders> findByPage(String username,int start, int rows) throws Exception {
        List<Orders> orders = new ArrayList<Orders>();
        Orders order;
        String sql = "SELECT * FROM orders where username=? limit ?,?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,username);
            this.pstmt.setInt(2,start);
            this.pstmt.setInt(3,rows);

            ResultSet rs = (ResultSet) this.pstmt.executeQuery();
            while(rs.next()) {
                order = new Orders();
                order.setId(rs.getInt(3));
                order.setGoodsName(rs.getString(4));
                order.setGoodsPrice(rs.getDouble(5));
                order.setGoodsImage(rs.getString(6));
                order.setTime(rs.getString(2));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw e;
        }
        this.pstmt.close();
        return orders;
    }

    @Override
    public List<Orders> findByPage1(String username, int start, int rows) throws Exception {
        // 当前时间
        Calendar ca = Calendar.getInstance();
        Date currentTime = ca.getTime();
        System.out.println(currentTime);

        // 退回七天，获取一周前的时间
        ca.add(Calendar.DATE,-7);
        Date weekAgoTime = ca.getTime();
        System.out.println(weekAgoTime);

        // 日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String c = sdf.format(currentTime);
        String w = sdf.format(weekAgoTime);

        List<Orders> orders = new ArrayList<Orders>();
        Orders order;
        String sql = "SELECT * FROM orders where username=? and time>? and time<? limit ?,?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,username);
            this.pstmt.setString(2,w);
            this.pstmt.setString(3,c);
            this.pstmt.setInt(4,start);
            this.pstmt.setInt(5,rows);

            ResultSet rs = (ResultSet) this.pstmt.executeQuery();
            while(rs.next()) {
                order = new Orders();
                order.setId(rs.getInt(3));
                order.setGoodsName(rs.getString(4));
                order.setGoodsPrice(rs.getDouble(5));
                order.setGoodsImage(rs.getString(6));
                order.setTime(rs.getString(2));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw e;
        }
        this.pstmt.close();
        return orders;
    }

    @Override
    public boolean doCreate(Orders order) throws Exception {
        boolean flag = false;
        String sql = "INSERT INTO orders values (?,?,?,?,?,?)";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1, order.getUsername());
            this.pstmt.setString(2, order.getTime());
            this.pstmt.setInt(3, order.getId());
            this.pstmt.setString(4, order.getGoodsName());
            this.pstmt.setDouble(5, order.getGoodsPrice());
            this.pstmt.setString(6, order.getGoodsImage());

            if(this.pstmt.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            throw e;
        }

        this.pstmt.close();
        return flag;
    }

    @Override
    public List<Orders> findByDate(String username) throws Exception {
        /* // 当前时间
        Date currentTime = Calendar.getInstance().getTime();
        // 退回七天，获取一周前的时间
        Calendar.getInstance().add(Calendar.DATE,-7);
        Date weekAgoTime = Calendar.getInstance().getTime();

        // 日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String c = sdf.format(currentTime);
        System.out.println("c--------------"+c);
        String w = sdf.format(weekAgoTime);
        System.out.println("w--------------"+w);*/

        // 当前时间
        Calendar ca = Calendar.getInstance();
        Date currentTime = ca.getTime();

        // 退回七天，获取一周前的时间
        ca.add(Calendar.DATE,-7);
        Date weekAgoTime = ca.getTime();

        // 日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String c = sdf.format(currentTime);
        String w = sdf.format(weekAgoTime);

        System.out.println("一周前-----------"+w);
        System.out.println("当前时间-----------"+c);

        List<Orders> orders = new ArrayList<Orders>();
        Orders order;
        String sql = "SELECT * FROM orders where username=? and time>? and time<?";
        try {
            this.pstmt = this.conn.prepareStatement(sql);
            this.pstmt.setString(1,username);
            this.pstmt.setString(2,w);
            this.pstmt.setString(3,c);
            ResultSet rs = (ResultSet) this.pstmt.executeQuery();
            while(rs.next()) {
                order = new Orders();
                order.setId(rs.getInt(3));
                order.setGoodsName(rs.getString(4));
                order.setGoodsPrice(rs.getDouble(5));
                order.setGoodsImage(rs.getString(6));
                order.setTime(rs.getString(2));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw e;
        }
        this.pstmt.close();
        return orders;
    }
}
