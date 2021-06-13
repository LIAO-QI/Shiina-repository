package com.pharmacy.pharmacy_system.business.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order1 {
    private Integer so_id;                //购物单编号
    private String order_id;              //购物单流水号
    private Integer s_id;                 //员工号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private String so_date;               //购物单日期
}
