package com.shiina.DAO;

import com.shiina.VO.User;

public interface UserDAO {

	// 根据username精确查找某一位用户
	public User findByUsername(String username) throws Exception;

	// 修改用户信息
	public boolean doUpdate(User user) throws Exception;

	// 增加用户
	public boolean doCreate(User user) throws  Exception;
}
