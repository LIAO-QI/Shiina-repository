package com.shiina.UTILS;

import com.shiina.DAO.OrdersDAO;
import com.shiina.DAO.OrdersDAOImpl;
import com.shiina.VO.Orders;
import com.shiina.VO.PageBean;
import java.util.List;

public class FindOrdersByPage {
    private OrdersDAO dao;

    public FindOrdersByPage() throws Exception {
        this.dao = new OrdersDAOImpl();
    }

    // 全部订单的分页
    public PageBean findByPage(String username, String uCurrentPage, String uRows) throws Exception {
        PageBean pb = new PageBean();

        int currentPage = Integer.parseInt(uCurrentPage);
        int rows = Integer.parseInt(uRows);

        int start = (currentPage-1)*rows;
        List<Orders> list = this.dao.findByPage(username,start,rows);

        int totalCount = this.dao.findAll(username).size();
        int totalPage = (totalCount%rows) == 0? totalCount/rows : (totalCount/rows)+1;

        pb.setRows(rows);
        pb.setCurrentPage(currentPage);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);

        return pb;
    }

    // 一周内的订单分页
    public PageBean findByPage1(String username, String uCurrentPage, String uRows) throws Exception {
        PageBean pb = new PageBean();

        int currentPage = Integer.parseInt(uCurrentPage);
        int rows = Integer.parseInt(uRows);

        int start = (currentPage-1)*rows;
        List<Orders> list = this.dao.findByPage1(username,start,rows);

        int totalCount = this.dao.findByDate(username).size();
        int totalPage = (totalCount%rows) == 0? totalCount/rows : (totalCount/rows)+1;

        pb.setRows(rows);
        pb.setCurrentPage(currentPage);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);

        return pb;
    }

}
