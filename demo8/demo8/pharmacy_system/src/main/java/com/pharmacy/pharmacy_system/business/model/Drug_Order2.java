package com.pharmacy.pharmacy_system.business.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Drug_Order2 extends Drug_Order1 {
    private Drug drug;  //药品信息
}
