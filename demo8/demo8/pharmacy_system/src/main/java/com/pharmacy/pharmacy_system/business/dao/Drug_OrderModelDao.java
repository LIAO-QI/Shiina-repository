package com.pharmacy.pharmacy_system.business.dao;


import com.pharmacy.pharmacy_system.business.model.Drug_Order1;
import com.pharmacy.pharmacy_system.business.model.Drug_Order2;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Drug_OrderModelDao {

    /**
     * 根据购物单id查询所有已购药品
     * @param so_id
     * @return
     */
    @Select("select * from sale_drug where so_id=#{so_id}")
    @Results(id = "drug_OrderMap", value = {
            @Result(column = "so_id", property = "so_id", id = true),
            @Result(column = "d_id", property = "d_id"),
            @Result(column = "num", property = "num"),
            @Result(column = "d_id", property = "drug", one = @One
                    (select = "com.pharmacy.pharmacy_system.business.dao.DrugModelDao.selectDrugAllByIdPrice"))
    })
    public List<Drug_Order2> selectAllDrug_Order(Integer so_id);


    /**
     * 批量插入
     * @param drugOrders
     * @return
     */
    @Insert("<script> insert into sale_drug (so_id, d_id, num) values" +
            "<foreach collection='list' item='item' index='index' separator=','>" +
            "<trim prefix='(' suffix=')' suffixOverrides=',' > #{item.so_id},#{item.d_id},#{item.num} " +
            " </trim>" +
            "</foreach>" +
            "</script>"
    )
    public Integer insertDrugOrderByForeach(List<Drug_Order1> drugOrders);


    /**
     * 根据so_id删除订单
     * @param so_id
     * @return
     */
    @Delete("delete from sale_drug where so_id=#{so_id}")
    public Integer deleteDrugOrderByOid(Integer so_id);

}
