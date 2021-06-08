package com.pharmacy.pharmacy_system.business.controller;


import com.pharmacy.pharmacy_system.base.result.Result;
import com.pharmacy.pharmacy_system.business.model.Order2;
import com.pharmacy.pharmacy_system.business.model.Order3;
import com.pharmacy.pharmacy_system.business.service.OrderModelService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value="order")
@RestController
public class OrderController {
    @Autowired
    OrderModelService OrderModelService;

    @GetMapping("selectAllOrder")
    public Result selectAllOrder(){
        return Result.result(OrderModelService.selectAllOrder());
    }

    @GetMapping("selectAllByProperties")
    public Result selectAllByProperties(Integer so_id,Integer s_id, String so_date){
        return Result.result(OrderModelService.selectAllByProperties(so_id,s_id,so_date));
    }

    @GetMapping("selectAllByPageProperties")
    public Result selectAllByPageProperties(Integer pageNum, Integer pageSize,Integer s_id, String so_date){
        return Result.result(OrderModelService.selectAllByPageProperties(pageNum,pageSize,s_id,so_date));
    }

    @GetMapping("selectOrderNumProperties")
    public Result selectOrderNumProperties(Integer s_id, String so_date){
        return Result.result(OrderModelService.selectOrderNumProperties(s_id,so_date));
    }

    @GetMapping("selectOrderById")
    public Result selectOrderById(Integer so_id){
        return Result.result(OrderModelService.selectOrderById(so_id));
    }

    @RequestMapping("insertOrder")
    @ApiImplicitParam(name = "order", value = "订单信息", required = true, dataType = "Order3")
    public Result insertOrder(@RequestBody  Order3 order){
        return Result.result(OrderModelService.insertOrder(order));
    }

    @GetMapping("deleteOrder")
    public Result deleteOrder(Integer so_id,Integer s_id,String so_date){
        return Result.result(OrderModelService.deleteOrder(so_id,s_id,so_date));
    }

    @GetMapping("selectAllSid")
    public Result selectAllSid(){
        return Result.result(OrderModelService.selectAllSid());
    }

    @GetMapping("selectOrderMoneyByOid")
    public Result selectOrderMoneyByOid(Integer so_id){
        return Result.result(OrderModelService.selectOrderMoneyByOid(so_id));
    }

    @GetMapping("selectTotalOrderMoney")
    public Result selectTotalOrderMoney(){
        return Result.result(OrderModelService.selectTotalOrderMoney());
    }
}
