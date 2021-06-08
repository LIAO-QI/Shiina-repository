package com.pharmacy.pharmacy_system.business.service.Impl;

import com.pharmacy.pharmacy_system.business.dao.OrderModelDao;
import com.pharmacy.pharmacy_system.business.service.AccountEntryModelService;
import com.pharmacy.pharmacy_system.business.service.OrderModelService;
import com.pharmacy.pharmacy_system.business.utils.AccountEntryModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AccountEntryModelServiceImpl implements AccountEntryModelService {
    @Autowired
    OrderModelDao orderModelDao;

    @Autowired
    AccountEntryModelUtils accountEntryModelUtils;

    @Autowired
    OrderModelService orderModelService;

    @Override
    public List<Map<String, Object>> selectAllAcc() {
        return accountEntryModelUtils.accountEntry(orderModelDao.selectAllOrder());
    }

    @Override
    public Double getAllEntryMoney() {
        return orderModelService.selectTotalOrderMoney();
    }
}
