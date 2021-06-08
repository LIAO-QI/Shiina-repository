package com.pharmacy.pharmacy_system.business.service;

import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.model.Order2;
import com.pharmacy.pharmacy_system.business.model.Order3;

import java.util.List;
import java.util.Map;

public interface OrderModelService {

    public List<Map<String,Object>> selectAllOrder();

    public List<Map<String,Object>> selectAllByProperties(Integer so_id, Integer s_id, String so_date);

    public PageInfo selectAllByPageProperties(Integer pageNum, Integer pageSize, Integer s_id, String so_date);

    public Integer selectOrderNumProperties(Integer s_id, String so_date);

    public List<Map<String,Object>> selectOrderById(Integer so_id);

    public Integer insertOrder(Order3 order);

    public Integer deleteOrder(Integer so_id, Integer s_id, String so_date);

    public List<Integer> selectAllSid();


    /*
    * 根据id查询购药单的金额
    * */
    public Double selectOrderMoneyByOid(Integer so_id);


    /*
    * 查询购药单总金额
    * */
    public Double selectTotalOrderMoney();

}
