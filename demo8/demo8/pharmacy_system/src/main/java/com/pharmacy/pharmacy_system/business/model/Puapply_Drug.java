package com.pharmacy.pharmacy_system.business.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Puapply_Drug {
    /**
     * 补货药品单  基本属性
     */
    public Integer ra_id;
    public Integer d_id;
    public Integer num;
    public Drug drug;
}