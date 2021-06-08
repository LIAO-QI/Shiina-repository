package com.pharmacy.pharmacy_system.business.utils;

import com.pharmacy.pharmacy_system.business.model.Puapply_Drug;
import com.pharmacy.pharmacy_system.business.model.PurchaseApply;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PurchaseApplyModelUtils {
    public List<Map<String,Object>> getAllPurApply(List<PurchaseApply> purchaseApplyList){
        List<Map<String,Object>> ls = new ArrayList<>();
        for (PurchaseApply p:purchaseApplyList) {
            Map<String, Object> map = new HashMap<>();
            map.put("ra_id",p.getRa_id());
            map.put("apply_id",p.getApply_id());
            map.put("produce_area",p.getProduce_area());
            map.put("produce_firm",p.getProduce_firm());
            map.put("approve",p.getApprove());
            map.put("ra_remarks",p.getRa_remarks());
            map.put("ra_date",p.getRa_date());
            map.put("drugs",p.getDrugs());
            double outMoney = 0.0;
            for (Puapply_Drug pd:p.getDrugs()) {
               int num= pd.getNum();
               double price= pd.getDrug().getPurchase_price();
               outMoney += num*price;
            }
            map.put("outMoney",outMoney);
            ls.add(map);
        }
        return ls;
    }
}
