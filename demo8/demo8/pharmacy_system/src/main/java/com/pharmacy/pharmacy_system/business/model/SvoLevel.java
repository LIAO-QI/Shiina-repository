package com.pharmacy.pharmacy_system.business.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SvoLevel {
    private Integer sv_id;        //药品等级号
    private Integer y_number;     //黄色预警数
    private Integer r_number;     //红色预警数
}
