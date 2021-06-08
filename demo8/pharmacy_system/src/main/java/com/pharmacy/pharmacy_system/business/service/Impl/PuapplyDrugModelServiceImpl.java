package com.pharmacy.pharmacy_system.business.service.Impl;

import com.pharmacy.pharmacy_system.business.dao.Puapply_DrugModelDao;
import com.pharmacy.pharmacy_system.business.service.PuapplyDrugModelService;
import com.pharmacy.pharmacy_system.business.utils.PuapplyDrugModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class PuapplyDrugModelServiceImpl implements PuapplyDrugModelService {

    @Autowired
    Puapply_DrugModelDao puapply_drugModelDao;

    @Autowired
    PuapplyDrugModelUtils puapplyDrugModelUtils;

    @Override
    public List<Map<String, Object>> selectApplyAll() {
        return puapplyDrugModelUtils.getAllPuapplyDrug(puapply_drugModelDao.selectApplyAll());
    }

    @Override
    public Integer deletePuApply(Integer ra_id) {
        return puapply_drugModelDao.deletePuApplyByPaId(ra_id);
    }
}
