package com.pharmacy.pharmacy_system.business.controller;

import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.service.SvoLevelModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "svo")
public class SvoLevelController {
    @Autowired
    SvoLevelModelService svoLevelModelService;

    @GetMapping(value = "select")
    public Result select(Integer sv_id){
        return Result.result(svoLevelModelService.selectSvoById(sv_id));
    }

    @GetMapping(value = "selectSvoLevelAll")
    public Result selectSvoLevelAll(){
        return Result.result(svoLevelModelService.selectSvoLevelAll());
    }
}
