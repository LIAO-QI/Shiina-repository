package com.pharmacy.pharmacy_system.business.service;

import com.pharmacy.pharmacy_system.business.model.DrugCategory;

import java.util.List;
import java.util.Map;

public interface DrugCategoryModelService {

    public List<Map<String,Object>> selectDrugCategory();

    public Integer updateDrugCategory(DrugCategory drugCategory);

    public Integer deleteDrugCategory(Integer c_id);

    public Integer insertDrugCategory(DrugCategory drugCategory);

    public List<Map<String,Object>> selectDrugCategoryById(Integer c_id);
}
