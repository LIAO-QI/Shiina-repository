package com.shiina.DAO;

import com.shiina.VO.Goods;
import java.util.ArrayList;
import java.util.List;

//此代理类(proxy)和实现类(impl)都是BookDAO的实现类
public class GoodsDAOProxy implements GoodsDAO {
	private GoodsDAO dao;

	public GoodsDAOProxy() throws Exception {
		this.dao = new GoodsDAOImpl();
	}

	@Override
	// 显示所有商品
	public List<Goods> findAll() throws Exception {
		List<Goods> goods = new ArrayList<Goods>();
		try {
			goods = this.dao.findAll();
		}catch(Exception e) {
			throw e;
		}finally {
			//this.conn.close();
		}
		return goods;
	}

	@Override
	public Goods findByID(int id) throws Exception {
		Goods goods = new Goods();
		try {
			//在此dao代理类,调用dao实现类的同名方法实现物理数据库的操作
			goods = this.dao.findByID(id);
		}catch(Exception e) {
			throw e;
		}finally {
			// 关闭数据库
			//this.conn.close();
		}
		return goods;
	}

	@Override
	public List<Goods> findByPage(int start, int rows) throws Exception {
		List<Goods> goods = new ArrayList<Goods>();
		try {
			goods = this.dao.findByPage(start,rows);
		}catch(Exception e) {
			throw e;
		}finally {
			//this.conn.close();
		}
		return goods;
	}
}
