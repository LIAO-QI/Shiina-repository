package com.pharmacy.pharmacy_system.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer de_id;       // 部门编号
    private String de_name;      // 部门名称
    private String de_manager;   // 部门经理
    private String de_remarks;   // 部门备注
    private String de_phone;     // 部门电话
}
