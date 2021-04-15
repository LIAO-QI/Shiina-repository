package com.shiina.UTILS;

import com.shiina.DAO.MessageDAO;
import com.shiina.DAO.MessageDAOImpl;
import com.shiina.VO.Message;
import com.shiina.VO.PageBean;
import java.util.List;

public class FindMessageByPage {
    private MessageDAO dao;

    public FindMessageByPage() throws Exception {
        this.dao = new MessageDAOImpl();
    }

    public PageBean findByPage(String uCurrentPage, String uRows) throws Exception {
        PageBean pb = new PageBean();

        int currentPage = Integer.parseInt(uCurrentPage);
        int rows = Integer.parseInt(uRows);

        int start = (currentPage-1)*rows;
        List<Message> list = this.dao.findByPage(start,rows);

        int totalCount = this.dao.findAll().size();
        int totalPage = (totalCount%rows) == 0? totalCount/rows : (totalCount/rows)+1;

        pb.setRows(rows);
        pb.setCurrentPage(currentPage);
        pb.setList(list);
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);

        return pb;
    }

}
