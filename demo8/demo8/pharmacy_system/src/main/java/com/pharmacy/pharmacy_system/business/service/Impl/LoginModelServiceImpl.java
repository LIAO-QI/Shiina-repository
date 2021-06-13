package com.pharmacy.pharmacy_system.business.service.Impl;


import com.pharmacy.pharmacy_system.base.result.MessageConstant;
import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.base.result.ResultCode;
import com.pharmacy.pharmacy_system.business.service.LoginModelService;
import org.springframework.stereotype.Service;

@Service
public class LoginModelServiceImpl implements LoginModelService {
    Result r = new Result();

    @Override
    public String login(String username, String password) {
        String str = "";
        if(username.equals("admin")&password.equals("admin")){
            str="loginSuccess";
            r =new Result(ResultCode.SUCCESS.code, MessageConstant.MESSAGE_ALERT_SUCCESS.msg, str);
        }else {
            str="loginFalse";
            r = new Result(ResultCode.FAIL.code, MessageConstant.MESSAGE_ALERT_ERROR.msg, str);
        }
        return str;
    }

    @Override
    public String logout() {
        return "logoutSuccess";
    }

    public Result getResult(String str){
        return  r;
    }
}
