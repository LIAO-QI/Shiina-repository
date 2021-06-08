package com.pharmacy.pharmacy_system.business.dao;

import com.pharmacy.pharmacy_system.business.model.Stock;
import com.pharmacy.pharmacy_system.business.model.StockAll;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface StockModelDao {

    /**
     * 查询全部进货单
     * @return
     */
    @Select("select * from purchase_order")
    @Results(id = "stockMap", value = {
            @Result(column = "po_id", property = "po_id", id = true),
            @Result(column = "stock_id", property = "stock_id"),
            @Result(column = "ra_id", property = "ra_id"),
            @Result(column = "po_date", property = "po_date"),
            @Result(column = "po_remarks", property = "po_remarks"),
            @Result(column = "ra_id", property = "purchaseApply", one = @One(
                    select = "com.pharmacy.pharmacy_system.business.dao.PurchaseApplyModelDao.selectPurApplyById"))

    })
    public List<StockAll> selectAllStock();


    /**
     * 根据进货流水号查询进货单
     * @param stock_id
     * @return
     */
    @Select("<script>" + "select * from purchase_order " +
            "<where>" +
            "<if test=' stock_id != null  and  stock_id !=   \"\" '>  stock_id=#{stock_id}  </if>" +
            "</where>" +
            "</script>"
    )
    @ResultMap("stockMap")
    List<StockAll> selectStockByAny(@Param("stock_id") String stock_id);


    /**
     * 根据id查询进货单
     * @param po_id
     * @return
     */
    @Select("select * from purchase_order where po_id=#{po_id}")
    @ResultMap("stockMap")
    public List<StockAll> selectStockById(Integer po_id);


    /**
     * 多属性分页查询进货单
     * @param po_date
     * @return
     */
    @Select("<script>" + "select * from purchase_order " +
            "<where>" +
            "<if test='po_date!=null  and po_date!= \"\" '> and po_date like concat('%',#{po_date},'%')  </if>" +
            "</where>" +
            "</script>"
    )
    @ResultMap("stockMap")
    public List<StockAll> selectAllByPageProperties(String po_date);


    /**
     * 根据id删除进货单
     * @param po_id
     * @return
     */
    @Delete("<script>" + "delete from purchase_order " +
            "<where>" +
            "<if test='po_id!=null  and po_id!= \"\" '> and po_id=#{po_id}  </if>" +
            "</where>" +
            "</script>"
    )
    public Integer deleteStockById(Integer po_id);

    /**
     * 添加进货单
     * @param stock
     * @return
     */
    @Insert("insert into purchase_order values(#{po_id},#{stock_id},#{ra_id},#{po_date},#{po_remarks}) ")
    public Integer insertStock(Stock stock);


    /**
     * 根据进货流水号查询订货单总数
     * @param stock_id
     * @return
     */
    @Select("<script>" + "select COUNT(*) from purchase_order " +
            "<where>" +
            "<if test='stock_id!=null and stock_id!= \"\" '> and stock_id=#{stock_id} </if>" +
            "</where>" +
            "</script>"
    )
    public Integer selectStockNum(String stock_id);

    /**
     * 根据生产厂商和approve属性间接查询订货单总数
     * @param produce_firm
     * @return
     */
    @Select("select COUNT(*) from replenish_apply where produce_firm=#{produce_firm} and approve=2")
    public Integer selectStockNum1(String produce_firm);
}
