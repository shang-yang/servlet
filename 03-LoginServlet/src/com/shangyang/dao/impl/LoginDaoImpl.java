package com.shangyang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shangyang.dao.LoginDao;
import com.shangyang.pojo.User;

public class LoginDaoImpl implements LoginDao{

	@Override
	public User checkLoginDao(String uname, String pwd) {
		// 声明jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明数据存储对象
		User u = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sxt", "root", "123456");
			// 创建sql命令
			String sql = "select * from text1 where uname=? and pwd=?";
			// 常见sql命令对象
			ps = conn.prepareStatement(sql);
			// 给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			// 执行
			rs = ps.executeQuery();
			// 遍历执行结果
			while(rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			// 关闭资源
			// 返回
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return u;
	}
	
	
	// 根据UID获取用户信息
	@Override
	public User checkUidDao(String uid) {
		// 声明jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明数据存储对象
		User u = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sxt", "root", "123456");
			// 创建sql命令
			String sql = "select * from text1 where uid=?";
			// 常见sql命令对象
			ps = conn.prepareStatement(sql);
			// 给占位符赋值
			ps.setString(1, uid);
			// 执行
			rs = ps.executeQuery();
			// 遍历执行结果
			while(rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			// 关闭资源
			// 返回
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return u;
	}
}
