package com.pharmacy.pharmacy_system.business.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.dao.DrugCategoryModelDao;
import com.pharmacy.pharmacy_system.business.dao.DrugModelDao;
import com.pharmacy.pharmacy_system.business.model.Drug;
import com.pharmacy.pharmacy_system.business.model.DrugCategory;
import com.pharmacy.pharmacy_system.business.service.DrugModelService;
import com.pharmacy.pharmacy_system.business.utils.DrugModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DrugModelServiceImpl implements DrugModelService {
    @Autowired
    DrugModelDao drugModelDao;

    @Autowired
    DrugCategoryModelDao drugCategoryModelDao;

    @Autowired
    DrugModelUtils drugModelUtils;

    @Override
    public List<Map<String, Object>> selectDrugAll() {
        List<Drug> drugList = drugModelDao.selectDrugAll();
        return drugModelUtils.getAllDrugTab(drugList);
    }

    @Override
    public PageInfo selectDrugAllPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Drug> drugList = drugModelDao.selectDrugAllPage();
        List<Map<String,Object>> ls = drugModelUtils.getAllDrugTab(drugList);
        PageInfo page = new PageInfo(ls);
        return page;
    }

    @Override
    public List<Map<String,Object>> selectDrugByAny(Drug drug) {
        DrugCategory drugCategory = new DrugCategory();
        List<Drug> drugList = drugModelDao.selectDrugByAny(drug);
        return drugModelUtils.getAllDrug(drugList);
    }

    @Override
    public PageInfo selectDrugByAnyPage(Integer pageNum, Integer pageSize, Drug drug) {
        PageHelper.startPage(pageNum,pageSize);
        List<Drug> drugList = drugModelDao.selectDrugByAny(drug);
        List<Map<String,Object>> ls= drugModelUtils.getAllDrug(drugList);
        PageInfo page = new PageInfo(ls);
        return page;
    }

    @Override
    public Integer deleteDrugById(Integer id) {
        return drugModelDao.deleteDrugById(id);
    }

    @Override
    public Integer upDateById(Drug drug) {
        return drugModelDao.upDateById(drug);
    }

    @Override
    public Integer insertDrugById(Drug drug) {
        System.out.println(drug.toString());
        return drugModelDao.insertDrugById(drug);
    }

    @Override
    public List<Map<String, Object>> selectDrugCategoryAll() {
        List<DrugCategory> drugCategoriesList = drugCategoryModelDao.selectDrugCategoryAll1();
        Map<String,Object> map=null;
        List<Map<String, Object>> ls = new ArrayList<>();
        for (DrugCategory drugCategory:drugCategoriesList) {
            map=new HashMap<>();
            map.put("c_id",drugCategory.getC_id());
            map.put("c_name",drugCategory.getC_name());
            map.put("c_remarks",drugCategory.getC_remarks());
            ls.add(map);
        }
        return ls;
    }

    @Override
    public Integer drugCount() {
        return drugModelDao.drugCount();
    }

    @Override
    public List<Map<String, Object>> selectDrugAllById(Integer d_id) {
        List<Drug> drugList = drugModelDao.selectDrugAllById(d_id);
        List<Map<String, Object>> ls = drugModelUtils.getAllDrug(drugList);
        return ls;
    }

    @Override
    public Integer drugCountAny(String d_name,Integer c_id,Integer sv_id) {
        return drugModelDao.drugCountAny(d_name,c_id,sv_id);
    }

    @Override
    public Integer upDateInventoryById(Integer d_id, Integer inventory) {
        return drugModelDao.upDateInventoryById(d_id,inventory);
    }

    @Override
    public Integer upDateRackSaveById(Integer d_id, Integer rack_save) {
        return drugModelDao.upDateRackSaveById(d_id,rack_save);
    }

    @Override
    public Integer upDateSaveById(Integer d_id, Integer rack_save, Integer inventory) {
        return drugModelDao.upDateSaveById(d_id,rack_save,inventory);
    }

    public Integer selectRackSaveById(Integer d_id){
        return drugModelDao.selectRackSaveById(d_id);
    }

    public Integer selectInventoryById(Integer d_id){
        return drugModelDao.selectInventoryById(d_id);
    }

}
