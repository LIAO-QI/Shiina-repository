package com.pharmacy.pharmacy_system.business.service;

import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.model.Drug;
import com.pharmacy.pharmacy_system.business.model.DrugCategory;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public interface DrugModelService {

    public List<Map<String,Object>> selectDrugAll();

    public PageInfo selectDrugAllPage(Integer pageNum, Integer pageSize);

    public List<Map<String,Object>> selectDrugByAny(Drug drug);

    public PageInfo selectDrugByAnyPage(Integer pageNum, Integer pageSize, Drug drug);

    public Integer deleteDrugById(Integer id);

    public Integer upDateById(Drug drug);

    public Integer insertDrugById(Drug drug);

    public List<Map<String,Object>> selectDrugCategoryAll();

    public Integer drugCount();

    public List<Map<String,Object>> selectDrugAllById(Integer d_id);

    public Integer drugCountAny(String d_name, Integer c_id, Integer sv_id);

    public Integer upDateInventoryById(Integer d_id, Integer inventory);

    public Integer upDateRackSaveById(Integer d_id, Integer rack_save);

    public Integer upDateSaveById(Integer d_id, Integer rack_save, Integer inventory);

    public Integer selectRackSaveById(Integer d_id);

    public Integer selectInventoryById(Integer d_id);
}
