package com.pharmacy.pharmacy_system.business.dao;

import com.pharmacy.pharmacy_system.business.model.DrugCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugCategoryModelDao {

    /**
     * 根据药品类别ID查询药品类别
     * @param c_id 药品类别ID
     * @return
     */
    @Select("select * from drug_category where c_id=#{c_id}")
    public DrugCategory selectDrugCategoryAll(int c_id);


    /**
     * 查询全部药品的药品类别
     */
    @Select("select * from drug_category")
    public List<DrugCategory> selectDrugCategoryAll1();


    /**
     * 根据ID删除药品类别
     */
    @Delete("delete from drug_category where c_id=#{c_id}")
    public Integer deleteDrugCategory(Integer c_id);


    /**
     * 根据ID修改药品类别
     */
    @Update("update drug_category set c_name=#{c_name},c_remarks=#{c_remarks} where c_id=#{c_id}")
    public Integer upDataById(DrugCategory drugCategory);


    /**
     * 添加药品类别
     */
    @Insert("insert into drug_category values(0,#{c_name},#{c_remarks})")
    public Integer insertDrugCategory(DrugCategory drugCategory);


    /**
     * 根据药品类别ID查询药品类别
     * @param c_id 药品类别ID
     * @return
     */
    @Select("select * from drug_category where c_id=#{c_id}")
    public List<DrugCategory> selectDrugCategoryAllById(int c_id);
}
