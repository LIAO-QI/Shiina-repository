package com.pharmacy.pharmacy_system.business.service;

import com.pharmacy.pharmacy_system.business.model.SvoLevel;

import java.util.List;
import java.util.Map;

public interface SvoLevelModelService {

    public SvoLevel selectSvoById(Integer sv_id);

    public List<Map<String,Object>> selectSvoLevelAll();
}
