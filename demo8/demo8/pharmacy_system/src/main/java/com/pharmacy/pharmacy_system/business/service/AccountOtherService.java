package com.pharmacy.pharmacy_system.business.service;

import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.model.AccountOther;

import java.util.List;

public interface AccountOtherService {

    List<AccountOther>selectAllAccountOtherWithPage();

    List<AccountOther> queryAccountOtherByObject(AccountOther accountOther);

    Integer insertAccountOther(AccountOther accountOther);

    Integer deleteAccountOther(Integer aoId);
}
