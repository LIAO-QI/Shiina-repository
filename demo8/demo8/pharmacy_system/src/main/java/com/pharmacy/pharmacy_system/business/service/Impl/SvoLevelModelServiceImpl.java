package com.pharmacy.pharmacy_system.business.service.Impl;

import com.pharmacy.pharmacy_system.business.dao.SvoLevelModelDao;
import com.pharmacy.pharmacy_system.business.model.SvoLevel;
import com.pharmacy.pharmacy_system.business.service.SvoLevelModelService;
import com.pharmacy.pharmacy_system.business.utils.SvoLevelModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SvoLevelModelServiceImpl implements SvoLevelModelService {

    @Autowired
    SvoLevelModelDao svoLevelModelDao;

    @Autowired
    SvoLevelModelUtils svoLevelModelUtils;

    @Override
    public SvoLevel selectSvoById(Integer sv_id) {
        return svoLevelModelDao.selectById(sv_id);
    }

    @Override
    public List<Map<String, Object>> selectSvoLevelAll() {
        return svoLevelModelUtils.selectSvoLevelAll(svoLevelModelDao.selectSvoLevelAll());
    }
}
