package com.pharmacy.pharmacy_system.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugPrice {
    private Integer dp_id;
    private Integer d_id;
    private Double price;
    private Double purchase_price;
}
