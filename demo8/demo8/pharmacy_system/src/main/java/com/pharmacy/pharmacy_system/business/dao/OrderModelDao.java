package com.pharmacy.pharmacy_system.business.dao;

import com.pharmacy.pharmacy_system.business.model.Order1;
import com.pharmacy.pharmacy_system.business.model.Order2;
import com.pharmacy.pharmacy_system.business.model.Order3;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderModelDao {

    /**
     * 查询所有售出订单
     * @return
     */
    @Select("select * from sale_order")
    @Results(id = "orderMap", value = {
            @Result(column = "so_id", property = "so_id", id = true),
            @Result(column = "order_id", property = "order_id"),
            @Result(column = "so_date", property = "so_date"),
            @Result(column = "s_id", property = "s_id"),
            @Result(column = "so_id", property = "drug_orders", many = @Many
                    (select = "com.pharmacy.pharmacy_system.business.dao.Drug_OrderModelDao.selectAllDrug_Order"))
    })
    public List<Order2> selectAllOrder();


    /**
     * 多属性查询购药单
     * @param so_id
     * @param s_id
     * @param so_date
     * @return
     */
    @Select("<script>" + "select * from sale_order " +
            "<where>" +
            "<if test='so_date!=null  and so_date!= \"\" '> and so_date like concat('%',#{so_date},'%')  </if>" +
            "<if test='s_id!=null  and s_id!= \"\" '> and s_id=#{s_id}  </if>" +
            "<if test='so_id!=null  and so_id!= \"\" '> and so_id=#{so_id}  </if>" +
            "</where>" +
            "</script>"
    )
    @ResultMap("orderMap")
    public List<Order2> selectAllByProperties(Integer so_id, Integer s_id, String so_date);


    /**
     * 多属性分页查询购药单
     * @param s_id
     * @param so_date
     * @return
     */
    @Select("<script>" + "select * from sale_order " +
            "<where>" +
            "<if test='so_date!=null  and so_date!= \"\" '> and so_date like concat('%',#{so_date},'%')  </if>" +
            "<if test='s_id!=null  and s_id!= \"\" '> and s_id=#{s_id}  </if>" +
            "</where>" +
            "</script>"
    )
    @ResultMap("orderMap")
    public List<Order2> selectAllByPageProperties(Integer s_id, String so_date);


    /**
     * 多属性查询购药单总数
     * @param s_id
     * @param so_date
     * @return
     */
    @Select("<script>" + "select COUNT(*) from sale_order " +
            "<where>" +
            "<if test='so_date!=null  and so_date!= \"\" '> and so_date like concat('%',#{so_date},'%')  </if>" +
            "<if test='s_id!=null  and s_id!= \"\" '> and s_id=#{s_id}  </if>" +
            "</where>" +
            "</script>"
    )
    public Integer selectOrderNumProperties(Integer s_id, String so_date);


    /**
     * 按id查询订单
     * @param so_id
     * @return
     */
    @Select("select * from sale_order where so_id=#{so_id} ")
    @ResultMap("orderMap")
    public List<Order2> selectOrderById(Integer so_id);


    /**
     * 插入购药单(单个)
     * @param order
     * @return
     */
    @Insert("insert into sale_order values(#{so_id},#{order_id},#{s_id},#{so_date}) ")
    @SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "so_id", before = false, resultType = int.class)
    public Integer insertOrder(Order1 order);


    /**
     * 删除购药单
     * @param so_id
     * @param s_id
     * @param so_date
     * @return
     */
    @Delete("<script>delete from sale_order" +
            "<where>" +
            "<if test='so_date!=null  and so_date!= \"\" '> and Convert(so_date,CHAR(20)) like concat('%',#{so_date},'%')  </if>" +
            "<if test='s_id!=null  and s_id!= \"\" '> and s_id=#{s_id}  </if>" +
            "<if test='so_id!=null  and so_id!= \"\" '> and so_id=#{so_id}  </if>" +
            "</where>" +
            "</script>")
    public Integer deleteOrder(Integer so_id, Integer s_id, String so_date);


    @Select("select DISTINCT(s_id) from staff_list")
    public List<Integer> selectAllSid();

}
