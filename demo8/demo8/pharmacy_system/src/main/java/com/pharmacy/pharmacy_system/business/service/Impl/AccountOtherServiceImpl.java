package com.pharmacy.pharmacy_system.business.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.dao.AccountOtherDao;
import com.pharmacy.pharmacy_system.business.model.AccountOther;
import com.pharmacy.pharmacy_system.business.service.AccountOtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountOtherServiceImpl implements AccountOtherService {
    @Autowired
    AccountOtherDao accountOtherDao;

    @Override
    public  List<AccountOther> selectAllAccountOtherWithPage() {

        return accountOtherDao.selectAllAccountOtherWithPage();
    }

    @Override
    public List<AccountOther> queryAccountOtherByObject(AccountOther accountOther) {
        return accountOtherDao.queryAccountOtherByObject(accountOther);
    }

    @Override
    public Integer insertAccountOther(AccountOther accountOther) {
        return accountOtherDao.insertAccountOther(accountOther);
    }

    @Override
    public Integer deleteAccountOther(Integer aoId) {
        return accountOtherDao.deleteAccountOther(aoId);
    }
}
