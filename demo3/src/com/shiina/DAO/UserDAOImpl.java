package com.shiina.DAO;

import com.shiina.DB.MySQLConnection;
import com.shiina.VO.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

	private Connection conn = null;

	// 这里采用PreparedStatement进行预处理，主要是为了方便SQL注入
	private PreparedStatement pstmt;

	public UserDAOImpl() throws Exception {
		conn = new MySQLConnection().getConnection();
	}

	@Override
	// 根据username查找
	public User findByUsername(String username) throws SQLException{
		User user = new User();
		String sql = "SELECT * FROM users WHERE username = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, username);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()) {
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setAge(rs.getInt(5));
			}else{
				System.out.println("NOT FOUND");
			}
		} catch (SQLException e) {
			throw e;
		}

		this.pstmt.close();
		return user;
	}

	@Override
	// 修改用户信息
	public boolean doUpdate(User user) throws SQLException {
		boolean flag = false;

		String sql = "UPDATE users SET password = ?, name = ?, sex = ?, age = ? WHERE username = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, user.getPassword());
			this.pstmt.setString(2, user.getName());
			this.pstmt.setString(3, user.getSex());
			this.pstmt.setInt(4, user.getAge());
			this.pstmt.setString(5, user.getUsername());

			if (this.pstmt.executeUpdate() > 0) {
				flag = true;
			}else{
				System.out.println("update失败");
			}
		} catch (SQLException e) {
			throw e;
		}

		this.pstmt.close();
		return flag;
	}

	// 增加用户
	@Override
	public boolean doCreate(User user) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO users(username,password,name,sex,age) values ( ? , ? , ? , ? , ? )";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, user.getUsername());
			this.pstmt.setString(2, user.getPassword());
			this.pstmt.setString(3, user.getName());
			this.pstmt.setString(4,user.getSex());
			this.pstmt.setInt(5,user.getAge());

			if(this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			throw e;
		}

		this.pstmt.close();
		return flag;
	}

}