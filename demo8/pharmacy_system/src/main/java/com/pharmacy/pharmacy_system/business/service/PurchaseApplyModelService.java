package com.pharmacy.pharmacy_system.business.service;

import com.pharmacy.pharmacy_system.business.model.PurchaseApply;
import com.pharmacy.pharmacy_system.business.model.PurchaseApplyDrug;

import java.util.List;
import java.util.Map;

public interface PurchaseApplyModelService {

    public Integer insertPurApply(PurchaseApplyDrug apply);

    public PurchaseApply selectPurApplyById(Integer ra_id);

    public List<Map<String,Object>> selectNoApply();

    public Integer UpdatePurApplyById(Integer ra_id);

    public Integer deletePurApplyById(Integer ra_id);

}
