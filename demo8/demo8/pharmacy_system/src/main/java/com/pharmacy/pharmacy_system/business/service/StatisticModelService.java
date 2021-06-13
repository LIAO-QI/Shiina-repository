package com.pharmacy.pharmacy_system.business.service;

import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.model.Statistic;

import java.util.List;
import java.util.Map;

public interface StatisticModelService {

    public List<Map<String,Object>> selectAllStatistic();

    public PageInfo selectAllByPage(Integer pageNum, Integer pageSize);

    public Statistic selectAllStatisticByDid(Integer d_id);

    public Integer selectInventoryByDid(Integer d_id);

    public Integer selectRacksaveByDid(Integer d_id);

    public Integer selectSaleNumByDid(Integer d_id);

    public Integer selectTotalInventory();

    public Integer selectTotalRacksave();

    public Integer selectTotalSaleNum();

}
