package com.pharmacy.pharmacy_system.business.controller;

import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.service.AccountEntryModelService;
import com.pharmacy.pharmacy_system.business.utils.AccountEntryModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="accountEntry")
@RestController
public class AccountEntryController {
    @Autowired
    AccountEntryModelService accountEntryModelService;

    @Autowired
    AccountEntryModelUtils accountEntryModelUtils;

    @GetMapping("selectAllAcc")
    public Result selectAllAcc(){
        return Result.result(accountEntryModelService.selectAllAcc());
    }

    @GetMapping("getAllEntryMoney")
    public Result getAllEntryMoney(){
        return Result.result(accountEntryModelService.getAllEntryMoney());
    }
}
