package com.pharmacy.pharmacy_system.business.controller;

import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.model.PurchaseApply;
import com.pharmacy.pharmacy_system.business.model.PurchaseApplyDrug;
import com.pharmacy.pharmacy_system.business.service.PurchaseApplyModelService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "purApply")
@RestController
public class PurchaseApplyModelController {
    @Autowired
    PurchaseApplyModelService purchaseApplyModelService;

    @GetMapping(value = "selectPurApplyById")
    public Result selectPurApplyById(Integer ra_id){
        return Result.result(purchaseApplyModelService.selectPurApplyById(ra_id));
    }

    @GetMapping(value = "deletePurApplyById")
    public Result deletePurApplyById(Integer ra_id){
        return Result.result(purchaseApplyModelService.deletePurApplyById(ra_id));
    }

    @GetMapping(value = "selectNoApply")
    public Result selectNoApply(){
        return Result.result(purchaseApplyModelService.selectNoApply());
    }

    /**
     *
     * @writer Shiina
     * @date 2021/03/26
     */
    @RequestMapping(value = "insertPurApply")
    @ApiImplicitParam(name = "apply", value = "补货信息", required = true, dataType = "PurchaseApplyDrug")
    public Result insertPurApply(@RequestBody PurchaseApplyDrug apply){
        return Result.result(purchaseApplyModelService.insertPurApply(apply));
    }

    @GetMapping(value = "UpdatePurApplyById")
    public Result UpdatePurApplyById(Integer ra_id){
        return Result.result(purchaseApplyModelService.UpdatePurApplyById(ra_id));
    }

}
