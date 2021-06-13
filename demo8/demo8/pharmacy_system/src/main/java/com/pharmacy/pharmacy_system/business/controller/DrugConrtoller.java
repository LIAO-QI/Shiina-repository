package com.pharmacy.pharmacy_system.business.controller;

import com.github.pagehelper.dialect.ReplaceSql;
import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.model.Drug;
import com.pharmacy.pharmacy_system.business.model.DrugCategory;
import com.pharmacy.pharmacy_system.business.model.SvoLevel;
import com.pharmacy.pharmacy_system.business.service.DrugModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RequestMapping(value = "drug")
@RestController
public class DrugConrtoller {

    @Autowired
    DrugModelService drugModelService;

    @GetMapping(value = "drugSelectAll")
    public Result drugSelectAll(){
        return Result.result(drugModelService.selectDrugAll());
    }

    @GetMapping(value = "drugSelectAllPage")
    public Result drugSelectAllPage(Integer pageNum, Integer pageSize){
        return Result.result(drugModelService.selectDrugAllPage(pageNum,pageSize));
    }

    @GetMapping(value = "drugSelectByAny")
    public Result drugSelectByAny(Drug drug){
        return Result.result(drugModelService.selectDrugByAny(drug));
    }

    @GetMapping(value = "drugSelectByAnyPage")
    public Result drugSelectByAnyPage(Integer pageNum, Integer pageSize,Drug drug){
        return Result.result(drugModelService.selectDrugByAnyPage(pageNum,pageSize,drug));
    }

    @GetMapping(value = "drugDeleteById")
    public Result drugDeleteById(Integer d_id){
        return Result.result(drugModelService.deleteDrugById(d_id),"success","error");
    }

    @GetMapping(value = "upDateById")
    public Result upDateById(Drug drug,Integer c_id,Integer sv_id){
        DrugCategory drugCategory = new DrugCategory();
        drugCategory.setC_id(c_id);
        drug.setCategory(drugCategory);
        SvoLevel svoLevel = new SvoLevel();
        svoLevel.setSv_id(sv_id);
        drug.setSvoLevel(svoLevel);
        return Result.result(drugModelService.upDateById(drug),"success","error");
    }

    @GetMapping(value = "insertDrugById")
    public Result insertDrugById(Drug drug,Integer c_id,Integer sv_id){
        DrugCategory drugCategory = new DrugCategory();
        drugCategory.setC_id(c_id);
        drug.setCategory(drugCategory);
        SvoLevel svoLevel = new SvoLevel();
        svoLevel.setSv_id(sv_id);
        drug.setSvoLevel(svoLevel);
        return Result.result(drugModelService.insertDrugById(drug),"success","error");
    }

    @GetMapping(value = "drugCategorySelectAll")
    public Result drugCategorySelectAll(){
        return Result.result(drugModelService.selectDrugCategoryAll());
    }

    @GetMapping(value = "drugCount")
    public Result drugCount(){
        return Result.result(drugModelService.drugCount());
    }

    @GetMapping(value = "drugSelectAllById")
    public Result drugSelectAllById(Integer d_id){
        return Result.result(drugModelService.selectDrugAllById(d_id));
    }

    @GetMapping(value = "drugCountAny")
    public Result drugCountAny(String d_name,Integer c_id,Integer sv_id){
        return Result.result(drugModelService.drugCountAny(d_name,c_id,sv_id));
    }

    @GetMapping(value = "upDateSaveById")
    public Result upDateSaveById(Integer d_id, Integer rack_save, Integer inventory){
        return Result.result(drugModelService.upDateSaveById(d_id,rack_save,inventory));
    }

    @GetMapping(value = "upDateInventoryById")
    public Result upDateInventoryById(Integer d_id,  Integer inventory){
        return Result.result(drugModelService.upDateInventoryById(d_id,inventory));
    }

    @GetMapping(value = "upDateRackSaveById")
    public Result upDateRackSaveById(Integer d_id, Integer rack_save){
        return Result.result(drugModelService.upDateRackSaveById(d_id,rack_save));
    }

}
