package com.pharmacy.pharmacy_system.business.service.Impl;

import com.pharmacy.pharmacy_system.business.dao.Puapply_DrugModelDao;
import com.pharmacy.pharmacy_system.business.dao.PurchaseApplyModelDao;
import com.pharmacy.pharmacy_system.business.model.Puapply_Drug;
import com.pharmacy.pharmacy_system.business.model.PurchaseApply;
import com.pharmacy.pharmacy_system.business.model.PurchaseApplyDrug;
import com.pharmacy.pharmacy_system.business.service.PurchaseApplyModelService;
import com.pharmacy.pharmacy_system.business.utils.PurchaseApplyModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class PurchaseApplyModelServiceImpl implements PurchaseApplyModelService {

    @Autowired
    PurchaseApplyModelDao purchaseApplyModelDao;

    @Autowired
    Puapply_DrugModelDao puapply_drugModelDao;

    @Autowired
    PurchaseApplyModelUtils purchaseApplyModelUtils;

    /**
     * 根据id查询补货单
     * @param ra_id
     * @return
     */
    @Override
    public PurchaseApply selectPurApplyById(Integer ra_id) {
        return purchaseApplyModelDao.selectPurApplyById(ra_id);
    }


    /**
     * @writer Shiina
     * @date 2021/03/26
     * @param apply
     * @return
     */
    @Override
    public Integer insertPurApply(PurchaseApplyDrug apply) {
        PurchaseApply o = new PurchaseApply(apply.getRa_id(), apply.getApply_id(), apply.getProduce_area(), apply.getProduce_firm(), apply.getApprove(), apply.getRa_remarks(), apply.getRa_date());
        Integer rs1 = purchaseApplyModelDao.insertPurApply(o);
        List<Puapply_Drug> drug_applys = apply.getDrugs();
        for (Puapply_Drug drug_apply : drug_applys) {
            drug_apply.setRa_id(o.getRa_id());
        }
        // 批量插入补货单的药品
        Integer rs2 = puapply_drugModelDao.insertPurApplyByForEach(drug_applys);
        return rs1 * rs2;
    }


    /**
     * 查询全部未进货的补货单
     * @return
     */
    @Override
    public List<Map<String, Object>> selectNoApply() {
        return purchaseApplyModelUtils.getAllPurApply(purchaseApplyModelDao.selectNoApply());
    }


    /**
     * @writer Shiina
     * @param pa_id
     * @return
     */
    @Override
    public Integer deletePurApplyById(Integer pa_id) {
        Integer rs1 = purchaseApplyModelDao.deletePurApplyById(pa_id);
        Integer rs2 = puapply_drugModelDao.deletePuApplyByPaId(pa_id);
        return rs1*rs2;
    }

    /**
     * 更新补货单的状态
     * @param pa_id
     * @return
     */
    @Override
    public Integer UpdatePurApplyById(Integer pa_id) {
        return purchaseApplyModelDao.UpdatePurApplyById(pa_id);
    }

}