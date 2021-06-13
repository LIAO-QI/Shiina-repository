package com.pharmacy.pharmacy_system.business.controller;

import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.service.StatisticModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="statistic")
@RestController
public class StatisticController {
    @Autowired
    StatisticModelService StatisticModelService;

    @GetMapping(value="selectAllStatistic")
    public Result selectAllStatistic(){
        return Result.result(StatisticModelService.selectAllStatistic());
    }

    @GetMapping(value="selectAllByPage")
    public Result selectAllByPage(Integer pageNum, Integer pageSize){
        return Result.result(StatisticModelService.selectAllByPage(pageNum,pageSize));
    }

    @GetMapping(value="selectAllStatisticByDid")
    public Result selectAllStatisticByDid(Integer d_id){
        return Result.result(StatisticModelService.selectAllStatisticByDid(d_id));
    }

    @GetMapping(value="selectInventoryByDid")
    public Result selectInventoryByDid(Integer d_id){
        return Result.result(StatisticModelService.selectInventoryByDid(d_id));
    }

    @GetMapping(value="selectRacksaveByDid")
    public Result selectRacksaveByDid(Integer d_id){
        return Result.result(StatisticModelService.selectRacksaveByDid(d_id));
    }

    @GetMapping(value="selectSaleNumByDid")
    public Result selectSaleNumByDid(Integer d_id){
        return Result.result(StatisticModelService.selectSaleNumByDid(d_id));
    }

    @GetMapping(value="selectTotalInventory")
    public Result selectTotalInventory(){
        return Result.result(StatisticModelService.selectTotalInventory());
    }

    @GetMapping(value="selectTotalRacksave")
    public Result selectTotalRacksave(){
        return Result.result(StatisticModelService.selectTotalRacksave());
    }

    @GetMapping(value="selectTotalSaleNum")
    public Result selectTotalSaleNum(){
        return Result.result(StatisticModelService.selectTotalSaleNum());
    }
}
