package com.pharmacy.pharmacy_system.business.service;

import java.util.List;
import java.util.Map;

public interface AccountEntryModelService {

    public List<Map<String,Object>> selectAllAcc();

    public Double getAllEntryMoney();
}
