package com.pharmacy.pharmacy_system.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 药品类别类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugCategory {
    private Integer c_id;              //药品类别ID
    private String c_name;             //药品类别名称
    private String c_remarks;          //药品类别备注
}
