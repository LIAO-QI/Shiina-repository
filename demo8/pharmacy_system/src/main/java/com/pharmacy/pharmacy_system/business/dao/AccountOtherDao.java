package com.pharmacy.pharmacy_system.business.dao;

import com.pharmacy.pharmacy_system.business.model.AccountOther;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountOtherDao {

    @Select("select * from account_other")
    List<AccountOther> selectAllAccountOtherWithPage();

    @Select("<script>" +
            "select * from account_other\n" +
            "<where>" +
            "<if test=\"accountOther.ao_name neq null and accountOther.ao_name neq ''  \">" +
            "ao_name = #{accountOther.ao_name}\n" +
            "</if>" +
            "<if test=\"accountOther.ao_date neq null and accountOther.ao_date neq  ''\">" +
            "and ao_date = #{accountOther.ao_date}\n" +
            "</if>" +
            "</where>" +
            "</script>")
    List<AccountOther> queryAccountOtherByObject(@Param("accountOther") AccountOther accountOther);

    @Insert("<script>" +
            "insert into account_other values(default,#{accountOther.ao_name},#{accountOther.ao_money}," +
            "#{accountOther.ao_remarks},#{accountOther.ao_date})" +
            "</script>")
    Integer insertAccountOther(@Param("accountOther") AccountOther accountOther);

    @Delete("delete from account_other where ao_id=#{aoId}")
    Integer deleteAccountOther(@Param("aoId") Integer aoId);

}
