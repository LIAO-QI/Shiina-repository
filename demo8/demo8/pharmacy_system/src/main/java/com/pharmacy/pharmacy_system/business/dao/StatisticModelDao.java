package com.pharmacy.pharmacy_system.business.dao;


import com.pharmacy.pharmacy_system.business.model.Statistic;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticModelDao {
    /*
     * 查询所有
     * */
    @Results(id = "statisticMap", value = {
            @Result(column = "d_id", property = "d_id", id = true),
            @Result(column = "inventory", property = "inventory"),
            @Result(column = "rack_save", property = "rack_save"),
            @Result(column = "d_id", property = "saleNum", one = @One(select = "com.pharmacy.pharmacy_system.business.dao.StatisticModelDao.selectSaleNumByDid"))
    })
    @Select("select d_id,inventory,rack_save from drug_list")
    //查询全部
    public List<Statistic> selectAllStatistic();


    /*
     * 按照药品id查询 库存、架存、销售量
     * */
    @ResultMap("statisticMap")
    @Select("select d_id,inventory,rack_save from drug_list where d_id=#{d_id}")
    //查询全部
    public Statistic selectAllStatisticByDid(Integer d_id);


    /*
     * 按照药品id查询   库存
     * */
    @Select("select inventory  from drug_list where d_id=#{d_id}")
    public Integer selectInventoryByDid(Integer d_id);


    /*
     * 按照药品id查询  架存
     * */
    @Select("select rack_save  from drug_list where d_id=#{d_id}")
    public Integer selectRacksaveByDid(Integer d_id);


    /*
     * 按照药品id查询  销售量
     * */
    @Select("select SUM(num) from sale_drug where d_id=#{d_id}")
    public Integer selectSaleNumByDid(Integer d_id);

}
