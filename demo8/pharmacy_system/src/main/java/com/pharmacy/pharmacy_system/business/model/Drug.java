package com.pharmacy.pharmacy_system.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 *药品类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Drug {
    private Integer d_id;                //药品ID
    private String d_name;               //药品名称
    private DrugCategory category = new DrugCategory();  //药品类型
    private String produce_date;         //药品生产日期
    private String expiration_date;      //药品有效日期至
    private String sfda;                 //国药准字
    private String produce_batch;        //药品产品批号
    private String d_remarks;            //药品说明
    private Integer inventory;           //药品库存
    private Integer rack_save;           //药品架存
    private SvoLevel svoLevel;           //药品销量等级
    private DrugPrice drugPrice;         //药品价格
    private Double purchase_price;       //药品进价
    private Double sale_price;           //药品售价
}
