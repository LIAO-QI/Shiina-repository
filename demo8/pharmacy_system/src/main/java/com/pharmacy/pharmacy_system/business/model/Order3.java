package com.pharmacy.pharmacy_system.business.model;

import io.swagger.annotations.ApiImplicitParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order3 extends  Order1 {
    private List<Drug_Order1> drugOrder1s;
}
