package com.pharmacy.pharmacy_system.business.dao;

import com.pharmacy.pharmacy_system.business.model.SvoLevel;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SvoLevelModelDao {
    /**
     * 根据销售等级ID查询销售等级信息
     * @return
     */
    @Select("select * from drug_svo where sv_id=#{sv_id}")
    public SvoLevel selectById(Integer sv_id);

    /**
     * 查询全部销量等级
     */
    @Select("select * from drug_svo")
    public List<SvoLevel> selectSvoLevelAll();
}
