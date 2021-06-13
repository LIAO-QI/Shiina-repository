package com.pharmacy.pharmacy_system.business.service.Impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.dao.StaffModelDao;
import com.pharmacy.pharmacy_system.business.model.Staff;
import com.pharmacy.pharmacy_system.business.service.StaffModelService;
import com.pharmacy.pharmacy_system.business.utils.StaffModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StaffModelServiceImpl implements StaffModelService {

    @Autowired
    StaffModelDao StaffModelDao;

    @Autowired
    StaffModelUtils StaffModelUtils;


    @Override
    public List<Map<String,Object>> selectAllStaff() {
        List<Map<String, Object>> lm = StaffModelUtils.getAllStaff(StaffModelDao.selectAllStaff());
        return lm;
    }

    @Override
    public PageInfo selectAllByPage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String, Object>> lm = StaffModelUtils.getAllStaff(StaffModelDao.selectAllStaff());

        PageInfo page = new PageInfo(lm);
        return page;

    }

    public Integer deleteStaffById(Integer s_id){
        return StaffModelDao.deleteStaffById(s_id);
    }

    public Integer insertStaff(Staff staff){
        return StaffModelDao.insertStaff(staff);

    }

    public Integer updateStaffAll(Staff staff){
        return StaffModelDao.updateStaffAll(staff);
    }


    public List<Map<String,Object>> selectStaffByProperties(String s_name,String s_address,String s_phone,Integer de_id){
        List<Map<String, Object>> lm = StaffModelUtils.getAllStaff(StaffModelDao.selectStaffByProperties(s_name,s_address,s_phone,de_id));
        return lm;
    }

    public PageInfo selectAllByPageProperties(Integer pageNum, Integer pageSize,String s_name,Integer de_id){
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String, Object>> lm = StaffModelUtils.getAllStaff(StaffModelDao.selectAllByPageProperties(s_name,de_id));
        PageInfo page = new PageInfo(lm);
        return page;
    }

    public Integer selectStaffNumProperties(String s_name,Integer de_id){
        return StaffModelDao.selectStaffNumProperties(s_name,de_id);
    }

    public Integer selectStaffNum(){
        return StaffModelDao.selectStaffNum();
    }

    public List<Map<String,Object>> selectStaffById(Integer s_id){
        List<Map<String, Object>> lm=StaffModelUtils.getAllStaff(StaffModelDao.selectStaffById(s_id));
        return lm;
    }
}
