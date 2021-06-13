package com.pharmacy.pharmacy_system.business.controller;

import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.model.Puapply_Drug;
import com.pharmacy.pharmacy_system.business.service.PuapplyDrugModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping(value="PuapplyDrug")
@RestController
public class PuapplyDrugController {
    @Autowired
    PuapplyDrugModelService drugModelService;

    @GetMapping("deletePuApply")
    public Result deletePuApply(Integer ra_id){
        return Result.result(drugModelService.deletePuApply(ra_id));
    };

    @GetMapping("selectApplyAll")
    public Result selectApplyAll(){
        return Result.result(drugModelService.selectApplyAll());
    };

}
