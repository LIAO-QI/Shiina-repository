package com.pharmacy.pharmacy_system.business.dao;


import com.google.common.eventbus.DeadEvent;
import com.pharmacy.pharmacy_system.business.model.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentModelDao {

    /**
     * 按id查询部门
     * @param de_id
     * @return
     */
    @Select("select * from staff_department where de_id = #{de_id}")
    public Department selectDepartmentByid(Integer de_id);


    /**
     * 查询所有的部门信息
     * @return
     */
    @Select("select * from staff_department")
    public List<Department> selectAllDepartment();


    /**
     * 按id删除部门
     * @param de_id
     * @return
     */
    @Delete("delete from staff_department where de_id = #{de_id}")
    public Integer deleteDepartmentById(Integer de_id);


    /**
     * 添加部门
     * @param department
     * @return
     */
    @Insert("insert into staff_department values(#{de_id},#{de_name},#{de_manager},#{de_remarks},#{de_phone})")
    public Integer insertDepartment(Department department);


    /**
     * 按id修改部门
     * @param department
     * @return
     */
    @Update("update staff_department set de_name=#{de_name},de_manager=#{de_manager},de_remarks=#{de_remarks},de_phone=#{de_phone} where de_id=#{de_id} ")
    public Integer updateDepartmentById(Department department);

}
