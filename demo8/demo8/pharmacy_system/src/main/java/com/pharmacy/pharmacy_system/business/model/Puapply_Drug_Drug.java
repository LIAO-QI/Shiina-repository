package com.pharmacy.pharmacy_system.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Puapply_Drug_Drug extends Puapply_Drug {
    //补货申请单从表基本属性(1) + 药品基本属性(1)
    private Drug drug;
}
