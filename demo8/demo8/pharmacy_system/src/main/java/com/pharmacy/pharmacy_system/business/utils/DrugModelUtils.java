package com.pharmacy.pharmacy_system.business.utils;


import com.pharmacy.pharmacy_system.business.model.Drug;
import com.pharmacy.pharmacy_system.business.model.SvoLevel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class DrugModelUtils {
    private Map<String,Object> map=null;

    public List<Map<String,Object>> getAllDrug(List<Drug> drugList){
        List<Map<String, Object>> ls = new ArrayList<>();
        for (Drug drug:drugList) {
            map=new HashMap<>();
            map.put("d_id",drug.getD_id());
            map.put("d_name",drug.getD_name());
            map.put("category",drug.getCategory());
            map.put("produce_date",drug.getProduce_date());
            map.put("expiration_date",drug.getExpiration_date());
            map.put("sfda",drug.getSfda());
            map.put("produce_batch",drug.getProduce_batch());
            map.put("d_remarks",drug.getD_remarks());
            map.put("inventory",drug.getInventory());
            map.put("rack_save",drug.getRack_save());
            map.put("svoLevel",drug.getSvoLevel());
            map.put("purchase_price",drug.getPurchase_price());
            map.put("sale_price",drug.getSale_price());
            ls.add(map);
        }
        return ls;
    }

    public List<Map<String,Object>> getAllDrugTab(List<Drug> drugList){
        DrugModelUtils drugModelUtils = new DrugModelUtils();
        List<Map<String, Object>> ls = new ArrayList<>();
        for (Drug drug:drugList) {
            map=new HashMap<>();
            map.put("d_id",drug.getD_id());
            map.put("d_name",drug.getD_name());
            map.put("category",drug.getCategory());
            map.put("produce_date",drug.getProduce_date());
            map.put("expiration_date",drug.getExpiration_date());
            map.put("sfda",drug.getSfda());
            map.put("produce_batch",drug.getProduce_batch());
            map.put("d_remarks",drug.getD_remarks());
            map.put("inventory",drug.getInventory());
            map.put("rack_save",drug.getRack_save());
            map.put("warn",drugModelUtils.tAge(drug,drug.getSvoLevel()));
            map.put("svoLevel",drug.getSvoLevel());
            ls.add(map);
        }
        return ls;
    }

    public String tAge(Drug drug, SvoLevel svoLevel){
        String tag = null;
        if(drug.getInventory()<svoLevel.getY_number() && drug.getInventory()>=svoLevel.getR_number()){
            tag="yellow";
        }
        else if(drug.getInventory()<svoLevel.getR_number() && drug.getInventory()>=0){
            tag="red";
        }
        else {
            tag="full";
        }
        return tag;
    }
}
