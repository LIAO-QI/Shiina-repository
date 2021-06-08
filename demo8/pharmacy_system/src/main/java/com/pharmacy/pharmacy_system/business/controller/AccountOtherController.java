package com.pharmacy.pharmacy_system.business.controller;


import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.model.AccountOther;
import com.pharmacy.pharmacy_system.business.service.AccountOtherService;
import com.pharmacy.pharmacy_system.business.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("其他支出接口")
@RestController
@RequestMapping("AccountOtherController")
public class AccountOtherController {
    @Autowired
    AccountOtherService accountOtherService;

    @ApiOperation("分页查询全部")
    @GetMapping("selectAllAccountOtherWithPage")
    public Result selectAllAccountOtherWithPage(){
        return Result.result(accountOtherService.selectAllAccountOtherWithPage());
    }

    @ApiOperation(value = "自定义分页查询咨询师")
    @PostMapping("queryAccountOtherByObject")
    public Result queryAccountOtherByObject(@RequestBody AccountOther accountOther){
        return Result.result(accountOtherService.queryAccountOtherByObject(accountOther));
    }

    @ApiOperation("新增其他费用")
    @PostMapping("insertAccountOther")
    public Result insertAccountOther(@RequestBody AccountOther accountOther){
        System.out.println(accountOther);
        return  Result.result(accountOtherService.insertAccountOther(accountOther));
    }

    @ApiOperation("删除其他费用")
    @GetMapping("deleteAccountOther")
        public Result deleteAccountOther(Integer aoId){
        System.out.println(aoId);
        return  Result.result(accountOtherService.deleteAccountOther(aoId));
    }

}
