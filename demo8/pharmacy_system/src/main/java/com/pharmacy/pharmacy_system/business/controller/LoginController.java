package com.pharmacy.pharmacy_system.business.controller;


import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.service.LoginModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.XmlRootElement;

@RequestMapping(value="login")
@RestController
public class LoginController {
    @Autowired
    LoginModelService LoginModelService;

    @GetMapping(value ="login")
    public Result login(String username, String password){
        Result r= LoginModelService.getResult(LoginModelService.login(username,password));
        return r;
    }

    @GetMapping(value ="logout")
    public Result logout(){
        return Result.result(LoginModelService.logout());
    }

}
