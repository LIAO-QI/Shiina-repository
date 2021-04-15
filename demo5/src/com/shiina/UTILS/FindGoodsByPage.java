package com.shiina.UTILS;

import com.shiina.DAO.GoodsDAO;
import com.shiina.DAO.GoodsDAOImpl;
import com.shiina.VO.Goods;
import com.shiina.VO.PageBean;

import java.util.List;

public class FindGoodsByPage {
    private GoodsDAO dao;

    public FindGoodsByPage() throws Exception {
        this.dao = new GoodsDAOImpl();
    }

    public PageBean findByPage(String uCurrentPage, String uRows) throws Exception {
        PageBean pb = new PageBean();

        int currentPage = Integer.parseInt(uCurrentPage);
        int rows = Integer.parseInt(uRows);

        int start = (currentPage-1)*rows;
        List<Goods> list = this.dao.findByPage(start,rows);

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
