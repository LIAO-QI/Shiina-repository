package com.pharmacy.pharmacy_system.business.utils;

import com.pharmacy.pharmacy_system.business.model.Order2;
import com.pharmacy.pharmacy_system.business.service.OrderModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountEntryModelUtils {

    @Autowired
    OrderModelService orderModelService;

    public List<Map<String,Object>> accountEntry(List<Order2> order2s){
        List<Map<String,Object>> ls = new ArrayList<>();
        for (Order2 o:order2s) {
            Map<String,Object> map = new HashMap<>();
            map.put("so_id",o.getSo_id());
            map.put("order_id",o.getOrder_id());
            map.put("so_date",o.getSo_date());
            map.put("money",orderModelService.selectOrderMoneyByOid(o.getSo_id()));
            ls.add(map);
        }
        return ls;
    }

}
