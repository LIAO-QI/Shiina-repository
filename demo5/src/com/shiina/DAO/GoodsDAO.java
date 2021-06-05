package com.shiina.DAO;

import com.shiina.VO.Goods;
import java.util.List;

public interface GoodsDAO {
	// 显示所有商品
	public List<Goods> findAll() throws Exception;

	// 根据id查询某样商品信息
	public Goods findByID(int id) throws Exception;

	// 分页
	public List<Goods> findByPage(int start, int rows) throws Exception;

}
