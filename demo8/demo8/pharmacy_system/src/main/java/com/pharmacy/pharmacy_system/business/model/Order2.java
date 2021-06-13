package com.pharmacy.pharmacy_system.business.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order2 extends Order1 {
    private List<Drug_Order2> drug_orders;  //购买药品
}
