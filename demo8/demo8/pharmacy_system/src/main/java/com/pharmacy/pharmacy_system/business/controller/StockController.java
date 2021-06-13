package com.pharmacy.pharmacy_system.business.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.dao.StockModelDao;
import com.pharmacy.pharmacy_system.business.model.PurchaseApply;
import com.pharmacy.pharmacy_system.business.model.Stock;
import com.pharmacy.pharmacy_system.business.model.StockAll;
import com.pharmacy.pharmacy_system.business.service.Impl.StockModelServiceImpl;
import com.pharmacy.pharmacy_system.business.service.StockModelService;
import com.pharmacy.pharmacy_system.business.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="stock")
@RestController
public class StockController {
    @Autowired
    StockModelService stockModelService;

    @Autowired
    StockModelServiceImpl StockModelServiceImpl;

    @Autowired
    StockModelDao StockModelDao;

    @GetMapping("selectAllStock")
    public Result selectAllStock(){
        return Result.result(StockModelServiceImpl.selectAllStock());
    }

    @GetMapping("selectStockById")
    public Result selectStockById(Integer po_id){
        return Result.result(StockModelServiceImpl.selectStockById(po_id));
    }

    @GetMapping("selectAllByPageProperties")
    public Result selectAllByPageProperties(Integer pageNum, Integer pageSize, String stock_date){
        return Result.result(StockModelServiceImpl.selectAllByPageProperties(pageNum,pageSize,stock_date));
    }

    @GetMapping("deleteStockById")
    public Result deleteStockById(Integer po_id){
        return Result.result(StockModelServiceImpl.deleteStockById(po_id));
    }

    @GetMapping("insertStock")
    public Result insertStock(Stock stock){
        System.out.println(stock+"---");
        return Result.result(StockModelServiceImpl.insertStock(stock));
    }

    @GetMapping("getTotalMoney")
    public Result getTotalMoney(){
        return Result.result(StockModelServiceImpl.getTotalMoney(StockModelDao.selectAllStock()));
    }


    @GetMapping("selectStockByAny")
    public Result selectStockByAny(Integer pageNum, Integer pageSize, String stock_id, String produce_firm){
        System.out.println("---s:"+stock_id+" ---p:"+produce_firm);
        PageHelper.startPage(pageNum,pageSize);
        PageInfo page = new PageInfo(stockModelService.selectStockByAny(stock_id,produce_firm));
        System.out.println("totalNum --- " + page.getSize());
        return Result.result(page);
    }

    @GetMapping("selectStockNum")
    public Result selectStockNum(String stock_id, String produce_firm){
        System.out.println("selectStockNum --- " + produce_firm);
        return Result.result(stockModelService.selectStockNum(stock_id,produce_firm));
    }
}