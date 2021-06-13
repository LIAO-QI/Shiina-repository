package com.pharmacy.pharmacy_system.business.controller;

import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.service.AccountOutModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="accountOut")
@RestController
public class AccountOutController {
    @Autowired
    AccountOutModelService accountOutModelService;

    @GetMapping("selectAllOut")
    public Result selectAllAccOut(){
        return Result.result(accountOutModelService.selectAllAccOut());
    }

    @GetMapping("getAllOutMoney")
    public Result getAllOutMoney(){
        return Result.result(accountOutModelService.getAllOutMoney());
    }
}
