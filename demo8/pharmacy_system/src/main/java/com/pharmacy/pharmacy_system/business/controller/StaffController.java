package com.pharmacy.pharmacy_system.business.controller;


import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.model.Staff;
import com.pharmacy.pharmacy_system.business.service.StaffModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="staff")
@RestController
public class StaffController {
    @Autowired
    StaffModelService staffModelService;

    @GetMapping(value="selectAllStaff")
    public Result selectAllStaff(){
        return Result.result(staffModelService.selectAllStaff());
    }

    @GetMapping(value="selectAllByPage")
    public Result selectAllByPage(Integer pageNum, Integer pageSize){
        return Result.result(staffModelService.selectAllByPage(pageNum,pageSize));
    }

    @GetMapping("deleteStaffById")
    public Result deleteStaffById(Integer s_id){
        return Result.result(staffModelService.deleteStaffById(s_id));
    }

    @GetMapping("insertStaff")
    public Result insertStaff(Staff staff){

        return Result.result(staffModelService.insertStaff(staff));
    }

    @GetMapping("updateStaffAll")
    public Result updateStaffAll(Staff staff){
        //需与前端交互，先查询，后修改
        return Result.result(staffModelService.updateStaffAll(staff));
    }

    @GetMapping("selectStaffByProperties")
    public Result selectStaffByProperties(String s_name,String s_address,String s_phone,Integer de_id){
        return Result.result(staffModelService.selectStaffByProperties(s_name,s_address,s_phone,de_id));
    }

    @GetMapping("selectAllByPageProperties")
    public Result selectAllByPageProperties(Integer pageNum, Integer pageSize,String s_name,Integer de_id){
        return Result.result(staffModelService.selectAllByPageProperties(pageNum,pageSize,s_name,de_id));
    }

    @GetMapping("selectStaffNumProperties")
    public Result selectStaffNumProperties(String s_name,Integer de_id){
        return Result.result(staffModelService.selectStaffNumProperties(s_name,de_id));
    }

    @GetMapping("selectStaffNum")
    public Result selectStaffNum(){
        return Result.result(staffModelService.selectStaffNum());
    }

    @GetMapping("selectStaffById")
    public Result selectStaffById(Integer s_id){
        return Result.result(staffModelService.selectStaffById(s_id));
    }
}
