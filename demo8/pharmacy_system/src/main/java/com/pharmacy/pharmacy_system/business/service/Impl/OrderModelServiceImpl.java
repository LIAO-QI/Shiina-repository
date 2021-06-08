package com.pharmacy.pharmacy_system.business.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.dao.Drug_OrderModelDao;
import com.pharmacy.pharmacy_system.business.dao.OrderModelDao;
import com.pharmacy.pharmacy_system.business.model.*;
import com.pharmacy.pharmacy_system.business.service.DrugModelService;
import com.pharmacy.pharmacy_system.business.service.OrderModelService;
import com.pharmacy.pharmacy_system.business.utils.OrderModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderModelServiceImpl implements OrderModelService {

    @Autowired
    OrderModelDao OrderModelDao;

    @Autowired
    Drug_OrderModelDao Drug_OrderModelDao;

    @Autowired
    OrderModelUtils OrderModelUtils;

    @Autowired
    com.pharmacy.pharmacy_system.business.service.DrugModelService DrugModelService;

    public List<Map<String,Object>> selectAllOrder(){
        return OrderModelUtils.getAllOrder(OrderModelDao.selectAllOrder());
    }

    public List<Map<String,Object>> selectAllByProperties(Integer so_id,Integer s_id,String so_date){
        return OrderModelUtils.getAllOrder(OrderModelDao.selectAllByProperties(so_id,s_id,so_date));
    }


    public PageInfo selectAllByPageProperties(Integer pageNum, Integer pageSize, Integer s_id, String so_date){
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String, Object>> lm = OrderModelUtils.getAllOrder(OrderModelDao.selectAllByPageProperties(s_id,so_date));
        PageInfo page = new PageInfo(lm);
        return page;
    }

    public Integer selectOrderNumProperties(Integer s_id,String so_date){
        return OrderModelDao.selectOrderNumProperties(s_id,so_date);
    }

    public List<Map<String,Object>> selectOrderById(Integer so_id){
        return OrderModelUtils.getAllOrder(OrderModelDao.selectOrderById(so_id));
    }

    public Integer insertOrder(Order3 order){
        Order1 o = new Order1(order.getSo_id(), order.getOrder_id(),order.getS_id(),order.getSo_date());
        Integer rs1=OrderModelDao.insertOrder(o);
        List<Drug_Order1> drug_orders = order.getDrugOrder1s();
        for(Drug_Order1 drug_order:drug_orders){
            drug_order.setSo_id(o.getSo_id());
            //药品销售数量
            Integer num = drug_order.getNum();
            //架存
            Integer reckSave = DrugModelService.selectRackSaveById(drug_order.getD_id());
            //修改架存
            DrugModelService.upDateRackSaveById(drug_order.getD_id(),reckSave-num);
        }
        Integer rs2 = Drug_OrderModelDao.insertDrugOrderByForeach(drug_orders);
        return rs1*rs2;
    }

    public Integer deleteOrder(Integer so_id,Integer s_id,String so_date){
        List<Order2> ls = OrderModelDao.selectAllByProperties(so_id,s_id,so_date);
        Integer m = OrderModelDao.deleteOrder(so_id,s_id,so_date);
        for(Order2 o:ls){
            m*=Drug_OrderModelDao.deleteDrugOrderByOid(o.getSo_id());
        }
        return m;
    }

    public List<Integer> selectAllSid(){
        return OrderModelDao.selectAllSid();
    }

    public Double selectOrderMoneyByOid(Integer so_id){
        List<Drug_Order2> list = Drug_OrderModelDao.selectAllDrug_Order(so_id);
        double totalMoney = 0.0;
        for(Drug_Order2 d:list){
            totalMoney+=d.getNum()*d.getDrug().getSale_price();
        }
        return totalMoney;
    }

    public Double selectTotalOrderMoney(){
        List<Order2> list = OrderModelDao.selectAllOrder();
        double totalMoney = 0.0;
        for(Order2 order2:list){
            List<Drug_Order2> l = order2.getDrug_orders();
            for(Drug_Order2 d:l){
                totalMoney+=d.getNum()*d.getDrug().getSale_price();
            }
        }
        return totalMoney;
    }
}
