package com.pharmacy.pharmacy_system.business.utils;

import com.pharmacy.pharmacy_system.business.dao.DrugModelDao;
import com.pharmacy.pharmacy_system.business.model.Drug_Order2;
import com.pharmacy.pharmacy_system.business.model.Order2;
import com.pharmacy.pharmacy_system.business.service.DrugModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderModelUtils {

    public List<Map<String,Object>> getAllOrder(List<Order2> orderList){
        List<Map<String,Object>> lm = new ArrayList<>();
        Map<String,Object> map = null;
        for(Order2 o:orderList){
            //添加销售单基本信息
            map = new HashMap<>();
            map.put("so_id",o.getSo_id());
            map.put("order_id",o.getOrder_id());
            map.put("so_date",o.getSo_date());
            map.put("s_id",o.getS_id());
            List<Drug_Order2> doList = o.getDrug_orders();
            Double totalMoney = 0.0;    //总金额
            //药品详情
            List<Map<String,Object>> myDrugList = new ArrayList<>();
            Map<String,Object> myDrugMap = null;
            for(Drug_Order2 d_o:doList){
                myDrugMap = new HashMap<>();
                Double price = d_o.getDrug().getSale_price();
                //售出药品数量
                Integer num = d_o.getNum();
                myDrugMap.put("drug_name",d_o.getDrug().getD_name());
                myDrugMap.put("drug_num",num);  //药品数量
                myDrugMap.put("drug_price",price);
                totalMoney+=price*num;         //药品售价
                myDrugList.add(myDrugMap);
            }
            map.put("totalMoney",totalMoney);
            map.put("drugs",myDrugList);
            lm.add(map);
        }
        return lm;
    }
}
