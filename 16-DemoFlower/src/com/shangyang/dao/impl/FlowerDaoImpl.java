package com.shangyang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shangyang.dao.FlowerDao;
import com.shangyang.pojo.Flower;

public class FlowerDaoImpl implements FlowerDao {

	@Override
	public List<Flower> selAll() {
		// 声明jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明变量
		List<Flower> flower = new ArrayList<Flower>();
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sxt", "root", "123456");
			// 创建sql命令
			String sql = "select * from test4";
			// 创建sql命令对象
			ps = conn.prepareStatement(sql);
			// 执行sql
			rs = ps.executeQuery();
			// 遍历结果
			while (rs.next()) {
				// 给变量赋值
				Flower f = new Flower();
				f.setId(rs.getInt("id"));
				f.setName(rs.getString("name"));
				f.setPrice(rs.getDouble("price"));
				f.setProduction(rs.getString("production"));
				flower.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 返回结果
		return flower;
	}

	@Override
	public int insFlower(Flower flower) {
		// 声明jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		int index = -1;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sxt", "root", "123456");
			// 创建sql命令
			String sql = "insert into test4 value(default,?,?,?)";
			// 创建sql命令对象
			ps = conn.prepareStatement(sql);
			// 给占位符赋值
			ps.setString(1, flower.getName());
			ps.setDouble(2, flower.getPrice());
			ps.setString(3, flower.getProduction());
			// 执行sql
			index = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 返回结果
		return index;
	}
}
