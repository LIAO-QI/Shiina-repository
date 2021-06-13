package com.pharmacy.pharmacy_system.business.utils;

import com.pharmacy.pharmacy_system.business.model.SvoLevel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SvoLevelModelUtils {
    public List<Map<String,Object>>  selectSvoLevelAll(List<SvoLevel> svoLevelList){
        List<Map<String,Object>> ls = new ArrayList<>();
        for (SvoLevel s:svoLevelList) {
            Map<String,Object> map = new HashMap<>();
            map.put("sv_id",s.getSv_id());
            map.put("y_number",s.getY_number());
            map.put("r_number",s.getR_number());
            ls.add(map);
        }
        return ls;
    }
}
