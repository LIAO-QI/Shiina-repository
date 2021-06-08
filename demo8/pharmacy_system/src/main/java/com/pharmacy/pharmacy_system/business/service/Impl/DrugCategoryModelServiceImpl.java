package com.pharmacy.pharmacy_system.business.service.Impl;

import com.pharmacy.pharmacy_system.business.dao.DrugCategoryModelDao;
import com.pharmacy.pharmacy_system.business.model.DrugCategory;
import com.pharmacy.pharmacy_system.business.service.DrugCategoryModelService;
import com.pharmacy.pharmacy_system.business.utils.DrugCategoryModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class DrugCategoryModelServiceImpl implements DrugCategoryModelService {
    @Autowired
    DrugCategoryModelDao drugCategoryModelDao;

    @Autowired
    DrugCategoryModelUtils drugCategoryModelUtils;

    @Override
    public List<Map<String, Object>> selectDrugCategory() {
        return drugCategoryModelUtils.drugCategory(drugCategoryModelDao.selectDrugCategoryAll1());
    }

    @Override
    public Integer updateDrugCategory(DrugCategory drugCategory) {
        return drugCategoryModelDao.upDataById(drugCategory);
    }

    @Override
    public Integer deleteDrugCategory(Integer c_id) {
        return drugCategoryModelDao.deleteDrugCategory(c_id);
    }

    @Override
    public Integer insertDrugCategory(DrugCategory drugCategory) {
        return drugCategoryModelDao.insertDrugCategory(drugCategory);
    }

    @Override
    public List<Map<String, Object>> selectDrugCategoryById(Integer c_id) {
        return drugCategoryModelUtils.drugCategory(drugCategoryModelDao.selectDrugCategoryAllById(c_id));
    }
}
