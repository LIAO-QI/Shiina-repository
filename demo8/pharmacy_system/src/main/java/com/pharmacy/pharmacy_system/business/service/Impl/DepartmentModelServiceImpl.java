package com.pharmacy.pharmacy_system.business.service.Impl;


import com.pharmacy.pharmacy_system.business.dao.DepartmentModelDao;
import com.pharmacy.pharmacy_system.business.model.Department;
import com.pharmacy.pharmacy_system.business.service.DepartmentModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentModelServiceImpl implements DepartmentModelService {
    public Department selectDepartmentByid(Integer de_id){
        return DepartmentModelDao.selectDepartmentByid(de_id);
    }

    @Autowired
    DepartmentModelDao DepartmentModelDao;

    public List<Department> selectAllDepartment(){
        List<Department> dapartments = DepartmentModelDao.selectAllDepartment();
        return dapartments;
    }

    public Integer deleteDepartmentById(Integer de_id){
        return DepartmentModelDao.deleteDepartmentById(de_id);
    }

    public Integer insertDepartment(Department department){
        return DepartmentModelDao.insertDepartment(department);
    }

    public Integer updateDepartmentById(Department department){
        return  DepartmentModelDao.updateDepartmentById(department);
    }
}
