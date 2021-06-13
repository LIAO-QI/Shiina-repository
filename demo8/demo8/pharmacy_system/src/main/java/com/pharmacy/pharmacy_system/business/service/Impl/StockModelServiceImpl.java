package com.pharmacy.pharmacy_system.business.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.dao.DrugModelDao;
import com.pharmacy.pharmacy_system.business.dao.Puapply_DrugModelDao;
import com.pharmacy.pharmacy_system.business.dao.StockModelDao;
import com.pharmacy.pharmacy_system.business.model.Puapply_Drug;
import com.pharmacy.pharmacy_system.business.model.PurchaseApply;
import com.pharmacy.pharmacy_system.business.model.Stock;
import com.pharmacy.pharmacy_system.business.model.StockAll;
import com.pharmacy.pharmacy_system.business.service.StockModelService;
import com.pharmacy.pharmacy_system.business.utils.StockModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StockModelServiceImpl implements StockModelService {

    @Autowired
    StockModelDao StockModelDao;

    @Autowired
    StockModelUtils StockModelUtils;

    @Autowired
    Puapply_DrugModelDao Puapply_DrugModelDao;

    @Autowired
    DrugModelDao DrugModelDao;

    public List<Map<String,Object>> selectAllStock(){
        return  StockModelUtils.selectAllStock(StockModelDao.selectAllStock());

    }

    public List<Map<String,Object>> selectStockById(Integer po_id){
        return  StockModelUtils.selectAllStock(StockModelDao.selectStockById(po_id));
    }

    public PageInfo selectAllByPageProperties(Integer pageNum, Integer pageSize, String po_date){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo page = new PageInfo(StockModelUtils.selectAllStock(StockModelDao.selectAllByPageProperties(po_date)));
        return page;
    }

    public Integer deleteStockById(Integer po_id){
        return  StockModelDao.deleteStockById(po_id);
    }

    public Integer insertStock(Stock stock){
        Integer a = StockModelDao.insertStock(stock);
        List<Puapply_Drug> pd = Puapply_DrugModelDao.selectAllPuapplyDrug(stock.getRa_id());
        Integer b = 0;
        //修改库存
        for(Puapply_Drug p:pd){
            b+=DrugModelDao.upDateInventoryById(p.getD_id(),DrugModelDao.selectDrugAllById(p.getD_id()).get(0).getInventory()+p.getNum());
        }
        return a+b;
    }

    public Double getTotalMoney(List<StockAll> stockList){
        return StockModelUtils.getTotalMoney(stockList);
    }

    @Override
    public List<StockAll> selectStockByAny(String stock_id, String produce_firm) {
        List<StockAll> stockAllList = StockModelDao.selectStockByAny(stock_id);
        for(StockAll stockAll: stockAllList){
            stockAll.setProduce_area(stockAll.getPurchaseApply().getProduce_area());
            stockAll.setProduce_firm(stockAll.getPurchaseApply().getProduce_firm());
            List<Puapply_Drug> puapply_drugs = stockAll.getPurchaseApply().getDrugs();
            stockAll.setDrugs(puapply_drugs);
            double singleMoney = 0.0;
            for(Puapply_Drug p:puapply_drugs){
                singleMoney+=p.getDrug().getPurchase_price()*p.getNum();
            }
            stockAll.setSingleMoney(singleMoney);
        }
        List<StockAll> stockAllList1 = new ArrayList<>();
        if(produce_firm!=null&&!produce_firm.equals("")){
            stockAllList.forEach(ele->{
                if(ele.getProduce_firm().equals(produce_firm)){
                    stockAllList1.add(ele);
                }
            });
            return stockAllList1;
        }else{
            return stockAllList;
        }
    }

    public Integer selectStockNum(String stock_id, String produce_firm){
        Integer total = StockModelDao.selectStockNum(stock_id);
        if(produce_firm != null && !produce_firm.equals("")){
                // 按produce_firm（生产厂商）进行查询
                Integer total1 = StockModelDao.selectStockNum1(produce_firm);
                return total1;
        }else {
            // 查询全部或按stock_id（进货流水号）进行查询
            return total;
        }
    }
}
