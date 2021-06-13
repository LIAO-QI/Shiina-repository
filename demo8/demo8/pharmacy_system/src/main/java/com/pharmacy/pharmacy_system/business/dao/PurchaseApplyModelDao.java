package com.pharmacy.pharmacy_system.business.dao;

import com.pharmacy.pharmacy_system.business.model.PurchaseApply;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseApplyModelDao {

    /**
     * 查询全部补货申请单
     */
    @Select("select * from replenish_apply")
    @Results(id = "purchaseApplyMap", value = {
            @Result(column = "ra_id", property = "ra_id", id = true),
            @Result(column = "apply_id", property = "apply_id"),
            @Result(column = "produce_area", property = "produce_area"),
            @Result(column = "produce_firm", property = "produce_firm"),
            @Result(column = "approve", property = "approve"),
            @Result(column = "ra_remarks", property = "ra_remarks"),
            @Result(column = "ra_date", property = "ra_date"),
            @Result(column = "ra_id", property = "drugs", many = @Many(select = "com.pharmacy.pharmacy_system.business.dao.Puapply_DrugModelDao.selectAllPuapplyDrug")),
    })
    public List<PurchaseApply> selectPurApplyAll();


    /**
     * 查询全部未批准的补货单
     */
    @Select("select * from replenish_apply where approve = 1")
    @ResultMap(value = "purchaseApplyMap")
    public List<PurchaseApply> selectNoApply();


    /**
     * 根据补货申请编号查询补货申请信息
     */
    @Select("select * from replenish_apply where ra_id=#{ra_id}")
    @ResultMap(value = "purchaseApplyMap")
    public PurchaseApply selectPurApplyById(Integer ra_id);


    /**
     * 批准并修改补货单
     */
    @Update("update replenish_apply set approve=2 where ra_id=#{ra_id}")
    public Integer UpdatePurApplyById(Integer ra_id);


    /**
     * 根据id删除补货订单
     * @param ra_id
     * @return
     */
    @Delete("delete from replenish_apply where ra_id=#{ra_id}")
    public Integer deletePurApplyById(Integer ra_id);


    /*
     * 添加补货单(approve初始值默认为1，即未进货的补货单)
     * */
    @Insert("insert into replenish_apply values(#{ra_id},#{apply_id},#{produce_area},#{produce_firm},#{approve},#{ra_remarks},#{ra_date}) ")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "ra_id", before = false, resultType = int.class)
    public Integer insertPurApply(PurchaseApply apply);
}
