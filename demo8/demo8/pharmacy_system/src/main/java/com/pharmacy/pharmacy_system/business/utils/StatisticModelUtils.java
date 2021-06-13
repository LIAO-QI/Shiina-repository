package com.pharmacy.pharmacy_system.business.utils;


import com.pharmacy.pharmacy_system.business.model.Statistic;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StatisticModelUtils {
    public List<Map<String,Object>> getAllStatistic(List<Statistic> statisticListList){
        List<Map<String,Object>> statistic_lm = new ArrayList<>();
        Map<String,Object> statisticMap = null;
        for(Statistic s:statisticListList){
            statisticMap = new HashMap<>();
            statisticMap.put("d_id",s.getD_id());
            statisticMap.put("inventory",s.getInventory());
            statisticMap.put("rack_save",s.getRack_save());
            statisticMap.put("saleNum",s.getSaleNum());
            statistic_lm.add(statisticMap);
        }

        return statistic_lm;
    }
}
