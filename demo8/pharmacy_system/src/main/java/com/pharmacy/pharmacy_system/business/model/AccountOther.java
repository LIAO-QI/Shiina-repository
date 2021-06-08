package com.pharmacy.pharmacy_system.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountOther {
    private Integer ao_id;
    private String ao_name;
    private String ao_money;
    private String ao_remarks;
    private String ao_date;
}
