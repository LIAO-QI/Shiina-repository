package com.pharmacy.pharmacy_system.business.service;

import java.util.List;
import java.util.Map;

public interface PuapplyDrugModelService {

    public List<Map<String,Object>> selectApplyAll();

    public Integer deletePuApply(Integer ra_id);

}
