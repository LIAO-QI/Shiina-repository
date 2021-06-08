package com.pharmacy.pharmacy_system.business.controller;

import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.model.DrugCategory;
import com.pharmacy.pharmacy_system.business.service.DrugCategoryModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="drugCategory")
@RestController
public class DrugCategoryController {
    @Autowired
    DrugCategoryModelService drugCategoryModelService;

    @GetMapping(value = "selectDrugCategory")
    public Result selectDrugCategory(){
        return Result.result(drugCategoryModelService.selectDrugCategory());
    }

    @GetMapping(value = "updateDrugCategory")
    public Result updateDrugCategory(DrugCategory drugCategory){
        return Result.result(drugCategoryModelService.updateDrugCategory(drugCategory));
    }

    @GetMapping(value = "deleteDrugCategory")
    public Result deleteDrugCategory(Integer c_id){
        return Result.result(drugCategoryModelService.deleteDrugCategory(c_id));
    }

    @GetMapping(value = "insertDrugCategory")
    public Result insertDrugCategory(DrugCategory drugCategory){
        return Result.result(drugCategoryModelService.insertDrugCategory(drugCategory));
    }

    @GetMapping(value = "selectDrugCategoryById")
    public Result selectDrugCategoryById(Integer c_id){
        return Result.result(drugCategoryModelService.selectDrugCategoryById(c_id));
    }

}
