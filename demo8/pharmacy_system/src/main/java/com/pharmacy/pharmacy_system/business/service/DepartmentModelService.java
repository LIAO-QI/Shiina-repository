package com.pharmacy.pharmacy_system.business.service;

import com.pharmacy.pharmacy_system.business.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DepartmentModelService {

    public Department selectDepartmentByid(Integer de_id);

    public List<Department> selectAllDepartment();

    public Integer deleteDepartmentById(Integer de_id);

    public Integer insertDepartment(Department department);

    public Integer updateDepartmentById(Department department);
}
