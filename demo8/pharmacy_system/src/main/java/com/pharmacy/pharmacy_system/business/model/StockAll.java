package com.pharmacy.pharmacy_system.business.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class StockAll extends PurchaseApply {
    /*
     * 进货单基本属性(1)+购药申请单基本属性(1)+购药申请单从表基本属性（n）+药品基本属性(1)
     * 查询
     * */
    private Integer po_id;           //进货编号
    private String stock_id;         //进货流水号
    private Integer ra_id;            //补货申请编号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private String po_date;      //进货日期
    private String po_remarks;   //进货备注
    private PurchaseApply purchaseApply;
    private double singleMoney;
}
