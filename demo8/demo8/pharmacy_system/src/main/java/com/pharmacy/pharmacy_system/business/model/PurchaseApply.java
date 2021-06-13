package com.pharmacy.pharmacy_system.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseApply {
    /**
     * 补货申请单基本属性
     */
    private Integer ra_id;             //补货单编号
    private String apply_id;           //补货流水号
    private String produce_area;       //生产产地
    private String produce_firm;       //生产厂商
    private String approve;            //是否批准进货
    private String ra_remarks;         //备注
    private List<Puapply_Drug> drugs;  //药品
    private String ra_date;            //补货时间

    public PurchaseApply(Integer ra_id, String apply_id, String produce_area, String produce_firm, String approve, String ra_remarks, String ra_date) {
        this.ra_id = ra_id;
        this.apply_id = apply_id;
        this.produce_area = produce_area;
        this.produce_firm = produce_firm;
        this.approve = approve;
        this.ra_remarks = ra_remarks;
        this.ra_date = ra_date;
    }
}
