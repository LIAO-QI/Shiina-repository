package com.pharmacy.pharmacy_system.business.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private Integer s_id;           //员工编号
    private String s_name;          //员工名字
    private String s_sex;           //员工性别
    private String s_birth;         //员工出生日期
    private String s_address;       //员工住址
    private String s_phone;         //员工电话
    private String s_duty;          //员工职务
    private Department department;  //员工部门
}
