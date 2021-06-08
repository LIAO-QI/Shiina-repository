package com.pharmacy.pharmacy_system.business.utils;

import com.pharmacy.pharmacy_system.business.model.Staff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StaffModelUtils {
    public List<Map<String,Object>> getAllStaff(List<Staff> staffList){
        List<Map<String,Object>> staff_lm = new ArrayList<>();
        Map<String,Object> staffMap = null;
        for(Staff s:staffList){
            staffMap = new HashMap<>();
            staffMap.put("s_id",s.getS_id());
            staffMap.put("s_name",s.getS_name());
            staffMap.put("s_sex",s.getS_sex());
            staffMap.put("s_birth",s.getS_birth());
            staffMap.put("s_address",s.getS_address());
            staffMap.put("s_phone",s.getS_phone());
            staffMap.put("s_duty",s.getS_duty());
            staffMap.put("department",s.getDepartment());
            staff_lm.add(staffMap);
        }
        return staff_lm;
    }
}
