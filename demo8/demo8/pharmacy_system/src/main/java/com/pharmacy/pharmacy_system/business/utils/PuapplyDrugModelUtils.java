package com.pharmacy.pharmacy_system.business.utils;

import com.pharmacy.pharmacy_system.business.model.Puapply_Drug;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PuapplyDrugModelUtils {
    public List<Map<String,Object>> getAllPuapplyDrug(List<Puapply_Drug> puapplyDrugs){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = null;
        for(Puapply_Drug puapply_drug:puapplyDrugs){
            map = new HashMap<>();
            map.put("ra_id",puapply_drug.getRa_id());
            map.put("d_id",puapply_drug.getD_id());
            map.put("num",puapply_drug.getNum());
            list.add(map);
        }

        return list;
    }
}
