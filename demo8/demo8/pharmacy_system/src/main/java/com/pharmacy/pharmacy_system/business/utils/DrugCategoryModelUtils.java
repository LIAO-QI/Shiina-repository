package com.pharmacy.pharmacy_system.business.utils;

import com.pharmacy.pharmacy_system.business.model.DrugCategory;
import com.pharmacy.pharmacy_system.business.model.SvoLevel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DrugCategoryModelUtils {
    public List<Map<String,Object>> drugCategory(List<DrugCategory> drugCategories){
        List<Map<String,Object>> ls = new ArrayList<>();
        for (DrugCategory d:drugCategories) {
            Map<String,Object> map = new HashMap<>();
            map.put("c_id",d.getC_id());
            map.put("c_name",d.getC_name());
            map.put("c_remarks",d.getC_remarks());
            ls.add(map);
        }
        System.out.println("类别----"+ls);
        return ls;
    }
}
