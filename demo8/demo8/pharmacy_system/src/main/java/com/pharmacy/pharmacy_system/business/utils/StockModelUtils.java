package com.pharmacy.pharmacy_system.business.utils;

import com.pharmacy.pharmacy_system.business.dao.DrugModelDao;
import com.pharmacy.pharmacy_system.business.dao.Puapply_DrugModelDao;
import com.pharmacy.pharmacy_system.business.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StockModelUtils {
    @Autowired
    Puapply_DrugModelDao puapply_drugModelDao;

    @Autowired
    DrugModelDao DrugModelDao;

    public List<Map<String,Object>> selectAllStock(List<StockAll> stockList){
        List<Map<String,Object>> lm = new ArrayList<>();
        Map<String,Object> map1 = null;
        for(StockAll s:stockList){
            //添加基本信息
            map1 = new HashMap<>();
            map1.put("po_id",s.getPo_id());
            map1.put("stock_id",s.getStock_id());
            map1.put("ra_id",s.getRa_id());
            map1.put("po_date",s.getPo_date());
            map1.put("po_remarks",s.getPo_remarks());
            //获取补货单
            PurchaseApply purchaseApply = s.getPurchaseApply();
            map1.put("produce_area",purchaseApply.getProduce_area());
            map1.put("produce_firm",purchaseApply.getProduce_firm());
            Integer ra_id = purchaseApply.getRa_id();
            //添加药品信息
            List<Puapply_Drug> puapply_drugs =purchaseApply.getDrugs();//从表
            List<Map<String,Object>> myDrugList = new ArrayList<>();
            Map<String,Object> map2 = null;
            double singleMoney = 0.0;
            for(Puapply_Drug p:puapply_drugs){
                map2 = new HashMap<>();
                //添加药品名称
                Integer d_id = p.getDrug().getD_id();
                map2.put("drug_name",p.getDrug().getD_name());
                map2.put("sfda",p.getDrug().getSfda());//国药准字
                //添加药品数量
                map2.put("drug_num",p.getNum());
                //添加某一单金额
                singleMoney+=p.getDrug().getPurchase_price()*p.getNum();
                myDrugList.add(map2);
            }
            map1.put("drugs",myDrugList);
            map1.put("singleMoney",singleMoney);

            lm.add(map1);
        }
        return lm;
    }

    public Double getTotalMoney(List<StockAll> stockList){
        List<Map<String,Object>> lm = selectAllStock(stockList);
        double totalMoney = 0.0;
        for(Map<String,Object> o:lm){
            totalMoney+= Double.parseDouble(o.get("singleMoney").toString());
        }
        return totalMoney;
    }
}
