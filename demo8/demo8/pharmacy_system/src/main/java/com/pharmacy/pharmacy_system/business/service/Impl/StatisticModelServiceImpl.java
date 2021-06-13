package com.pharmacy.pharmacy_system.business.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.dao.DrugModelDao;
import com.pharmacy.pharmacy_system.business.dao.StatisticModelDao;
import com.pharmacy.pharmacy_system.business.model.Drug;
import com.pharmacy.pharmacy_system.business.model.Statistic;
import com.pharmacy.pharmacy_system.business.service.StatisticModelService;
import com.pharmacy.pharmacy_system.business.utils.StatisticModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StatisticModelServiceImpl implements StatisticModelService {

    @Autowired
    StatisticModelUtils StatisticModelUtils;

    @Autowired
    StatisticModelDao StatisticModelDao;

    @Autowired
    DrugModelDao DrugModelDao;

    public List<Map<String,Object>> selectAllStatistic(){
        return StatisticModelUtils.getAllStatistic(StatisticModelDao.selectAllStatistic());
    }

    @Override
    public PageInfo selectAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String, Object>> lm = StatisticModelUtils.getAllStatistic(StatisticModelDao.selectAllStatistic());

        PageInfo page = new PageInfo(lm);
        return page;

    }

    @Override
    public Statistic selectAllStatisticByDid(Integer d_id) {
        return StatisticModelDao.selectAllStatisticByDid(d_id);
    }

    @Override
    public Integer selectInventoryByDid(Integer d_id) {
        return StatisticModelDao.selectInventoryByDid(d_id);
    }

    @Override
    public Integer selectRacksaveByDid(Integer d_id) {
        return StatisticModelDao.selectRacksaveByDid(d_id);
    }

    @Override
    public Integer selectSaleNumByDid(Integer d_id) {
        return StatisticModelDao.selectSaleNumByDid(d_id);
    }

    public Integer selectTotalInventory(){
        List<Drug> list = DrugModelDao.selectDrugAll();
        Integer totalInventory = 0;
        for(Drug d:list){
            totalInventory+=StatisticModelDao.selectInventoryByDid(d.getD_id());
        }
        return totalInventory;
    }

    public Integer selectTotalRacksave(){
        List<Drug> list = DrugModelDao.selectDrugAll();
        Integer totalRacksave = 0;
        for(Drug d:list){
            totalRacksave+=StatisticModelDao.selectRacksaveByDid(d.getD_id());
        }
        return totalRacksave;
    }

    public Integer selectTotalSaleNum(){
        List<Drug> list = DrugModelDao.selectDrugAll();
        Integer totalSaleNum = 0;
        for(Drug d:list){
            Integer saleNum = StatisticModelDao.selectSaleNumByDid(d.getD_id());
            if(saleNum==null)
            {
                saleNum=0;
            }

            totalSaleNum+=saleNum;
        }
        return totalSaleNum;
    }
}
