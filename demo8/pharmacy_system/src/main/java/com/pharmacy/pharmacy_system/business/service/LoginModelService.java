package com.pharmacy.pharmacy_system.business.service;

import com.pharmacy.pharmacy_system.base.result.Result;

public interface LoginModelService {
    public String login(String username, String password);

    public String logout();

    public Result getResult(String str);
}
