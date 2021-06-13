package com.pharmacy.pharmacy_system.business.dao;

import com.pharmacy.pharmacy_system.business.model.Puapply_Drug;
import com.pharmacy.pharmacy_system.business.model.Puapply_Drug;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Puapply_DrugModelDao {

    /**
     * 根据补货申请单的ID查询需要的药品
     */
    @Select("select * from replenish_drug where ra_id=#{ra_id}")
    @Results(id = "puapply_drugMap", value = {
            @Result(column = "ra_id", property = "ra_id", id = true),
            @Result(column = "d_id", property = "d_id"),
            @Result(column = "num", property = "num"),
            @Result(column = "d_id", property = "drug", one = @One(select = "com.pharmacy.pharmacy_system.business.dao.DrugModelDao.selectDrugAllById")),

    })
    public List<Puapply_Drug> selectAllPuapplyDrug(Integer ra_id);


    /**
     * 批量插入
     */
    @Insert("<script> insert into replenish_drug values" +
            "<foreach collection='list' item='item' index='index' separator=','>" +
            "<trim prefix='(' suffix=')' suffixOverrides=',' > #{item.ra_id},#{item.d_id},#{item.num} " +
            " </trim>" +
            "</foreach>" +
            "</script>")
    public Integer insertPurApplyByForEach(List<Puapply_Drug> drug_applys);


    /**
     * 根据补货申请单id删除某申请单的全部药品
     * @param ra_id
     * @return
     */
    @Delete("delete from replenish_drug where ra_id=#{ra_id} ")
    public Integer deletePuApplyByPaId(Integer ra_id);

    /**
     * 查询全部药品
     * @return
     */
    @Select("select * from replenish_drug")
    public List<Puapply_Drug> selectApplyAll();

}
