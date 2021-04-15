package com.shiina.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	//数据库连接驱动
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	//数据库连接地址
	private static final String URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";

	// 数据库用户名
	private static final String USERNAME ="root";

	// 数据库密码
	private static final String PASSWORD ="hx20184103";

	private Connection conn;

	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return conn;
	}

	// 关闭数据库连接
	public void close() throws Exception{
		if(this.conn != null) {
			try{
				this.conn.close();
			}catch(Exception e) {
				throw e;
			}
		}
	}
}
