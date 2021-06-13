package com.pharmacy.pharmacy_system.business.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug_Order1 {
    private Integer so_id;     //购物单号
    private Integer d_id;      //药品号
    private Integer num;       //药品数量
}
