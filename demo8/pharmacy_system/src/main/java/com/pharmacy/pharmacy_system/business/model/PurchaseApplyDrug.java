package com.pharmacy.pharmacy_system.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseApplyDrug extends PurchaseApply{
    //补货申请单基本属性(1)+补货申请单从表基本属性（n）+药品基本属性(1)
    private List<Puapply_Drug> drugs;
}
