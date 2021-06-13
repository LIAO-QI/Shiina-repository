package com.pharmacy.pharmacy_system.business.controller;


import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.model.Department;
import com.pharmacy.pharmacy_system.business.service.DepartmentModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="department")
@RestController
public class DepartmentController {
    @Autowired()
    DepartmentModelService departmentModelService;

    @GetMapping("selectDepartmentByid")
    public Result selectDepartmentByid(Integer de_id){
        return Result.result(departmentModelService.selectDepartmentByid(de_id));
    }

    @GetMapping("selectAllDepartment")
    public Result selectAllDepartment(){
        return Result.result(departmentModelService.selectAllDepartment());
    }

    @GetMapping("deleteDepartmentById")
    public Result deleteDepartmentById(Integer de_id){
        return Result.result(departmentModelService.deleteDepartmentById(de_id));
    }

    @GetMapping("insertDepartment")
    public Result insertDepartment(Department department){
        return Result.result(departmentModelService.insertDepartment(department));
    }

    @GetMapping("updateDepartmentById")
    public Result updateDepartmentById(Department department){
        return Result.result(departmentModelService.updateDepartmentById(department));
    }

}
