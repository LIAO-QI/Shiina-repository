package com.pharmacy.pharmacy_system.business.service;


import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.business.model.PurchaseApply;
import com.pharmacy.pharmacy_system.business.model.Stock;
import com.pharmacy.pharmacy_system.business.model.StockAll;

import java.util.List;
import java.util.Map;

public interface StockModelService {
    public List<Map<String,Object>> selectAllStock();

    public List<Map<String,Object>> selectStockById(Integer po_id);

    public PageInfo selectAllByPageProperties(Integer pageNum, Integer pageSize, String po_date);

    public Integer selectStockNum(String stock_id, String produce_firm);

    public Integer deleteStockById(Integer po_id);

    public Integer insertStock(Stock stock);

    public Double getTotalMoney(List<StockAll> stockList);

    public List<StockAll> selectStockByAny(String stock_id, String produce_firm);
}
