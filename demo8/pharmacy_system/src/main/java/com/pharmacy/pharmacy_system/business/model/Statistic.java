package com.pharmacy.pharmacy_system.business.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistic {
    /*
    * 统计
    * */
    private Integer d_id;       //药品id
    private Integer inventory;  //库存
    private Integer rack_save;  //架存
    private Integer saleNum;    //销售量
}
