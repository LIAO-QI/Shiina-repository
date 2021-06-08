package com.pharmacy.pharmacy_system.business.service;

import java.util.List;
import java.util.Map;

public interface AccountOutModelService {

    public List<Map<String,Object>> selectAllAccOut();

    public Double getAllOutMoney();
}
