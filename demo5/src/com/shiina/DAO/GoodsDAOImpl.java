package com.shiina.DAO;

import com.shiina.DB.MySQLConnection;
import com.shiina.VO.Goods;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAOImpl implements GoodsDAO {
	private Connection conn = null;

	// 这里采用PreparedStatement进行预处理，主要是为了方便SQL注入
	private PreparedStatement pstmt;

	public GoodsDAOImpl() throws Exception {
		conn = new MySQLConnection().getConnection();
	}

	@Override
	// 显示所有商品
	public List<Goods> findAll() throws SQLException {
		List<Goods> goods = new ArrayList<Goods>();
		Goods good;
		String sql = "SELECT * FROM goods";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = (ResultSet) this.pstmt.executeQuery();
			while(rs.next()) {
				good = new Goods();
				good.setId(rs.getInt(1));
				good.setGoodsName(rs.getString(2));
				good.setGoodsPrice(rs.getDouble(3));
				good.setGoodsImage(rs.getString(4));
				goods.add(good);
			}
		} catch (SQLException e) {
			throw e;
		}
		this.pstmt.close();
		return goods;
	}

	@Override
	public Goods findByID(int id) throws Exception {
		Goods goods = new Goods();
		String sql = "SELECT * FROM goods WHERE id = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, id);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()) {
				goods.setId(rs.getInt(1));
				goods.setGoodsName(rs.getString(2));
				goods.setGoodsPrice(rs.getDouble(3));
				goods.setGoodsImage(rs.getString(4));
			}else{
				System.out.println("NOT FOUND");
			}
		} catch (SQLException e) {
			throw e;
		}

		this.pstmt.close();
		return goods;
	}

	@Override
	public List<Goods> findByPage(int start, int rows) throws Exception {
		List<Goods> goods = new ArrayList<Goods>();
		Goods good;
		String sql = "SELECT * FROM goods limit ?,?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1,start);
			this.pstmt.setInt(2,rows);

			ResultSet rs = (ResultSet) this.pstmt.executeQuery();
			while(rs.next()) {
				good = new Goods();
				good.setId(rs.getInt(1));
				good.setGoodsName(rs.getString(2));
				good.setGoodsPrice(rs.getDouble(3));
				good.setGoodsImage(rs.getString(4));
				goods.add(good);
			}
		} catch (SQLException e) {
			throw e;
		}
		this.pstmt.close();
		return goods;
	}
}
