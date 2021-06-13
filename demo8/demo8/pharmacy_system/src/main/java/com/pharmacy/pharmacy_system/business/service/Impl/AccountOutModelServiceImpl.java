package com.pharmacy.pharmacy_system.business.service.Impl;

import com.pharmacy.pharmacy_system.business.dao.StockModelDao;
import com.pharmacy.pharmacy_system.business.model.StockAll;
import com.pharmacy.pharmacy_system.business.service.AccountOutModelService;
import com.pharmacy.pharmacy_system.business.utils.AccountOutModelUtils;
import com.pharmacy.pharmacy_system.business.utils.StockModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class AccountOutModelServiceImpl implements AccountOutModelService {
    @Autowired
    AccountOutModelUtils accountOutModelUtils;

    @Autowired
    StockModelDao stockModelDao;

    @Autowired
    StockModelUtils stockModelUtils;

    @Override
    public List<Map<String, Object>> selectAllAccOut() {
        return accountOutModelUtils.accountOut(stockModelDao.selectAllStock());
    }

    @Override
    public Double getAllOutMoney() {
        List<StockAll> ls = stockModelDao.selectAllStock();
        return stockModelUtils.getTotalMoney(ls);
    }

}
