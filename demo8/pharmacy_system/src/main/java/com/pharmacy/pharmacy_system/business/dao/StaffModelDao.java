package com.pharmacy.pharmacy_system.business.dao;


import com.pharmacy.pharmacy_system.business.model.Department;
import com.pharmacy.pharmacy_system.business.model.Staff;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffModelDao {

    /**
     * 查询全部
     * @return
     */
    @Select("select * from staff_list")
    @Results(id = "staffMap", value = {
            @Result(column = "s_id", property = "s_id", id = true),
            @Result(column = "s_name", property = "s_name"),
            @Result(column = "s_sex", property = "s_sex"),
            @Result(column = "s_birth", property = "s_birth"),
            @Result(column = "s_address", property = "s_address"),
            @Result(column = "s_phone", property = "s_phone"),
            @Result(column = "s_duty", property = "s_duty"),
            @Result(column = "de_id", property = "department", one = @One
                    (select = "com.pharmacy.pharmacy_system.business.dao.DepartmentModelDao.selectDepartmentByid", fetchType = FetchType.EAGER))
    })
    public List<Staff> selectAllStaff();


    /**
     * 分页查询
     * @return
     */
    @Select("select * from staff_list")
    @ResultMap("staffMap")
    public List<Staff> selectAllByPage();

    /**
     * 按id删除
     * @param s_id
     * @return
     */
    @Delete("delete from staff_list where s_id=#{s_id}")
    public Integer deleteStaffById(Integer s_id);


    /**
     * 插入员工   department只需给id
     * @param staff
     * @return
     */
    @Insert("insert into staff_list values(#{s_id},#{s_name},#{s_sex},#{s_birth},#{s_address},#{s_phone},#{s_duty},#{department.de_id})")
    public Integer insertStaff(Staff staff);


    /**
     * 修改员工信息
     * @param staff
     * @return
     */
    @Update("update staff_list set \n" +
            "s_name=#{s_name},s_sex=#{s_sex},s_birth=#{s_birth},s_address=#{s_address},s_phone=#{s_phone},s_duty=#{s_duty},de_id=#{department.de_id}\n" +
            "where s_id=#{s_id}")
    public Integer updateStaffAll(Staff staff);


    /**
     * 多属性查询
     * @param s_name
     * @param s_address
     * @param s_phone
     * @param de_id
     * @return
     */
    @Select("<script>" + "select * from staff_list" +
            "<where>" +
            "<if test='s_name!=null  and s_name!= \"\" '> and s_name=#{s_name}  </if>" +
            "<if test='s_address!=null  and s_address!= \"\" '> and s_address=#{s_address}  </if>" +
            "<if test='s_phone!=null  and s_phone!= \"\" '> and s_phone=#{s_phone}  </if>" +
            "<if test='de_id!=null  and de_id!= \"\" '> and de_id=#{de_id}  </if>" +
            "</where>" +
            "</script>"
    )
    @ResultMap("staffMap")
    public List<Staff> selectStaffByProperties(String s_name, String s_address, String s_phone, Integer de_id);


    /**
     * 多属性人数查询
     * @param s_name
     * @param de_id
     * @return
     */
    @Select("<script>" + "select COUNT(*) from staff_list" +
            "<where>" +
            "<if test='s_name!=null  and s_name!= \"\" '> and s_name like concat('%',#{s_name},'%')  </if>" +
            "<if test='de_id!=null  and de_id!= \"\" '> and de_id=#{de_id}  </if>" +
            "</where>" +
            "</script>"
    )
    public Integer selectStaffNumProperties(String s_name, Integer de_id);


    /**
     * 多属性分页查询
     * @param s_name
     * @param de_id
     * @return
     */
    @Select("<script>" + "select * from staff_list" +
            "<where>" +
            "<if test='s_name!=null  and s_name!= \"\" '> and s_name like concat('%',#{s_name},'%')  </if>" +
            "<if test='de_id!=null  and de_id!= \"\" '> and de_id=#{de_id}  </if>" +
            "</where>" +
            "</script>"
    )
    @ResultMap("staffMap")
    public List<Staff> selectAllByPageProperties(String s_name, Integer de_id);


    /**
     * 查询员工总数
     * @return
     */
    @Select("select COUNT(*) from staff_list")
    public Integer selectStaffNum();


    /**
     * 按id查询员工
     * @param s_id
     * @return
     */
    @Select("select * from staff_list where s_id=#{s_id}")
    @ResultMap("staffMap")
    public List<Staff> selectStaffById(Integer s_id);

}
