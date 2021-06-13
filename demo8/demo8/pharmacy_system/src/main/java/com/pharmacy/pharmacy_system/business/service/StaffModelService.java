package com.pharmacy.pharmacy_system.business.service;

import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.model.Staff;

import java.util.List;
import java.util.Map;

public interface StaffModelService {
    public List<Map<String,Object>> selectAllStaff();

    public PageInfo selectAllByPage(Integer pageNum, Integer pageSize);

    public Integer deleteStaffById(Integer s_id);

    public Integer insertStaff(Staff staff);

    public Integer updateStaffAll(Staff staff);

    public List<Map<String,Object>> selectStaffByProperties(String s_name, String s_address, String s_phone, Integer de_id);

    public PageInfo selectAllByPageProperties(Integer pageNum, Integer pageSize, String s_name, Integer de_id);

    public Integer selectStaffNumProperties(String s_name, Integer de_id);

    public Integer selectStaffNum();

    public List<Map<String,Object>> selectStaffById(Integer s_id);
}
