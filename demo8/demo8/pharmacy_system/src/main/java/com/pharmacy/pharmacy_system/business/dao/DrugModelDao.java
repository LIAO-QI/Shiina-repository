package com.pharmacy.pharmacy_system.business.dao;

import com.pharmacy.pharmacy_system.business.model.Drug;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugModelDao {
    /**
     * 查询药品全部（无分页）
     *
     * @return
     */
    @Results(id = "drugMap", value = {
            @Result(column = "d_id", property = "d_id", id = true),
            @Result(column = "d_name", property = "d_name"),
            @Result(column = "produce_date", property = "produce_date"),
            @Result(column = "expiration_date", property = "expiration_date"),
            @Result(column = "sfda", property = "sfda"),
            @Result(column = "produce_batch", property = "produce_batch"),
            @Result(column = "d_remarks", property = "d_remarks"),
            @Result(column = "inventory", property = "inventory"),
            @Result(column = "rack_save", property = "rack_save"),
            @Result(column = "svo_id", property = "svo_id"),
            @Result(column = "c_id", property = "category", one = @One(select = "com.pharmacy.pharmacy_system.business.dao.DrugCategoryModelDao.selectDrugCategoryAll", fetchType = FetchType.EAGER)),
            @Result(column = "sv_id", property = "svoLevel", one = @One(select = "com.pharmacy.pharmacy_system.business.dao.SvoLevelModelDao.selectById", fetchType = FetchType.EAGER))})
    @Select("select * from drug_list")
    public List<Drug> selectDrugAll();

    /**
     * 根据id查询药品
     * @return
     */
    @Results(value = {@Result(column = "d_id", property = "d_id", id = true),
            @Result(column = "d_name", property = "d_name"),
            @Result(column = "produce_date", property = "produce_date"),
            @Result(column = "expiration_date", property = "expiration_date"),
            @Result(column = "sfda", property = "sfda"),
            @Result(column = "produce_batch", property = "produce_batch"),
            @Result(column = "d_remarks", property = "d_remarks"),
            @Result(column = "inventory", property = "inventory"),
            @Result(column = "rack_save", property = "rack_save"),
            @Result(column = "svo_id", property = "svo_id"),
            @Result(column = "purchase_price", property = "purchase_price"),
            @Result(column = "sale_price", property = "sale_price"),
            @Result(column = "c_id", property = "category", one = @One(
                    select = "com.pharmacy.pharmacy_system.business.dao.DrugCategoryModelDao.selectDrugCategoryAll", fetchType = FetchType.EAGER)),
            @Result(column = "sv_id", property = "svoLevel", one = @One(
                    select = "com.pharmacy.pharmacy_system.business.dao.SvoLevelModelDao.selectById", fetchType = FetchType.EAGER)),
    })
    @Select("select * from drug_list where d_id=#{d_id}")
    public Drug selectDrugAllByIdPrice();

    /**
     * 查询药品全部（有分页）
     * @return
     */
    @Select("select * from drug_list")
    @ResultMap(value = "drugMap")
    public List<Drug> selectDrugAllPage();

    /**
     * 自定义查询
     */
    @Select({"<script>" + "select * from drug_list " +
            "<where>" +
            "<if test='d_id != null and d_id !=\"\" '>" +
            "and d_id=#{d_id} " +
            "</if>" +
            "<if test='category.c_id != null and category.c_id !=\"\" '>" +
            "and c_id=#{category.c_id} " +
            "</if>" +
            "<if test='d_name != null and d_name !=\"\" '>" +
            "and d_name like concat('%',#{d_name},'%')" +
            "</if>" +
            "<if test='svoLevel.sv_id != null and svoLevel.sv_id !=\"\" '>" +
            "and sv_id=#{svoLevel.sv_id} " +
            "</if>" +
            "</where>" +
            "</script>"})
    @ResultMap(value = "drugMap")
    public List<Drug> selectDrugByAny(Drug drug);

    /**
     * 根据药品ID查询药品
     */
    @Select("select * from drug_list where d_id=#{d_id}")
    @ResultMap(value = "drugMap")
    public List<Drug> selectDrugAllById(Integer d_id);

    /**
     * 根据药品ID删除药品
     * @return
     */
    @Delete("delete from drug_list where d_id=#{d_id}")
    public Integer deleteDrugById(Integer d_id);

    /**
     * 根据药品ID修改药品
     * @param drug
     * @return
     */
    @Update("update drug_list set d_name=#{d_name},produce_date=#{produce_date},expiration_date=#{expiration_date}," +
            "sfda=#{sfda},produce_batch=#{produce_batch},d_remarks=#{d_remarks}," +
            "inventory=#{inventory},rack_save=#{rack_save},c_id=#{category.c_id},sv_id=#{svoLevel.sv_id}," +
            "purchase_price=#{purchase_price},sale_price=#{sale_price}" +
            "where d_id=#{d_id}")
    public Integer upDateById(Drug drug);


    /**
     * 插入一条新的药品信息
     * @param drug
     * @return
     */
    @Insert("insert into drug_list values(0,#{d_name},#{category.c_id},#{produce_date},#{expiration_date},#{sfda},#{produce_batch},#{d_remarks},#{inventory},#{rack_save},#{svoLevel.sv_id},#{purchase_price},#{sale_price})")
    public Integer insertDrugById(Drug drug);


    /**
     * 查询药品总数
     */
    @Select("select count(*) from drug_list")
    public Integer drugCount();
    @Select({"<script>" +
            "select count(*) from drug_list" +
            "<where>" +
            "<if test='d_name != null and d_name !=\"\" '>" +
            " d_name like concat('%',#{d_name},'%') " +
            "</if>" +
            "<if test='c_id != null and c_id !=\"\" '>" +
            "and c_id=#{c_id} " +
            "</if>" +
            "<if test='sv_id != null and sv_id !=\"\" '>" +
            "and sv_id=#{sv_id} " +
            "</if>" +
            "</where>" +
            "</script>"})
    public Integer drugCountAny(String d_name, Integer c_id, Integer sv_id);


    /**
     * 根据药品ID修改药品库存
     */
    @Update("update drug_list set inventory=#{inventory} where d_id=#{d_id}")
    public Integer upDateInventoryById(Integer d_id, Integer inventory);



    /**
     * 根据药品ID修改药品架存
     */
    @Update("update drug_list set rack_save=#{rack_save} where d_id=#{d_id}")
    public Integer upDateRackSaveById(Integer d_id, Integer rack_save);


    /**
     * 根据药品ID修改药品架存和库存
     */
    @Update("update drug_list set rack_save=#{rack_save},inventory=#{inventory} where d_id=#{d_id}")
    public Integer upDateSaveById(Integer d_id, Integer rack_save, Integer inventory);


    /*
     * 根据药品id查询架存
     * */
    @Select("select rack_save from drug_list " +
            "where d_id=#{d_id}")
    public Integer selectRackSaveById(Integer d_id);


    /*
     * 根据药品id查询库存
     * */
    @Select("select inventory from drug_list where d_id=#{d_id}")
    public Integer selectInventoryById(Integer d_id);

}
