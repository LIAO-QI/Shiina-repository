package com.shiina.FACTORY;

import com.shiina.DAO.GoodsDAO;
import com.shiina.DAO.GoodsDAOProxy;

public class GoodsFactory {
	// 静态方法,返回值类型为Dao接口类型,实际返回Dao的代理类Proxy类型
	public static GoodsDAO getGoodsDAOInstance() throws Exception {
		return new GoodsDAOProxy();
	}
}
