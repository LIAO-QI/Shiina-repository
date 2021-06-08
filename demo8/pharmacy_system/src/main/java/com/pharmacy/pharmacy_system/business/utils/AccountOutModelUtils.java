package com.pharmacy.pharmacy_system.business.utils;

import com.pharmacy.pharmacy_system.business.model.StockAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountOutModelUtils {

    @Autowired
    StockModelUtils stockModelUtils;

    public List<Map<String,Object>> accountOut(List<StockAll> stockAlls){
        List<Map<String,Object>> ls = new ArrayList<>();
        for (StockAll s:stockAlls) {
            Map<String,Object> map = new HashMap<>();
            List<StockAll> list = new ArrayList<>();
            list.add(s);
            map.put("money",stockModelUtils.getTotalMoney(list));
            map.put("stock_id",s.getStock_id());
            map.put("ra_id",s.getRa_id());
            map.put("po_date",s.getPo_date());
            ls.add(map);
        }
        return ls;
    }
}
