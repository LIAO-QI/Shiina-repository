package com.shiina.FACTORY;

import com.shiina.DAO.UserDAO;
import com.shiina.DAO.UserDAOImpl;
import com.shiina.DAO.UserDAOProxy;

public class UserFactory {

	// 静态方法,返回值类型为Dao接口类型,实际返回Dao的实现类
	public static UserDAO getUserDAOInstance() throws Exception {
		return new UserDAOProxy();
	}
}


// 关于依赖关系：impl依赖conn  proxy依赖impl  servlet依赖proxy 前端依赖servlet