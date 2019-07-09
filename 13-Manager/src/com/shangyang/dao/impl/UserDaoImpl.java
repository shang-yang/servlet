package com.shangyang.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shangyang.dao.UserDao;
import com.shangyang.pojo.User;

public class UserDaoImpl implements UserDao {

	// 根据用户名和密码查询用户信息
	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		// 声明jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明变量
		User u  = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sxt", "root", "123456");
			// 创建sql命令
			String sql = "select * from test2 where uname=? and pwd=?";
			// 创建sql命令对象
			ps=conn.prepareStatement(sql);
			// 给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			// 执行sql
			rs = ps.executeQuery();
			// 遍历结果
			while(rs.next()) {
				// 给变量赋值
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
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
		return u;
	}

	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		// 声明jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		int index = -1;
		// 声明变量
		User u  = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/sxt", "root", "123456");
			// 创建sql命令
			String sql = "update test2 set pwd=? where uid=?";
			// 创建sql命令对象
			ps=conn.prepareStatement(sql);
			// 给占位符赋值
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
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

	@Override
	public List<User> userShowDao() {
		// 声明jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明变量
		List<User> lu = new ArrayList<User>();
		try {
			// 加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sxt", "root", "123456");
			// 创建sql命令
			String sql = "select * from test2";
			// 创建sql命令对象
			ps = conn.prepareStatement(sql);
			// 执行sql
			rs = ps.executeQuery();
			// 遍历结果
			while (rs.next()) {
				// 给变量赋值
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
				lu.add(u);
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
		return lu;
	}

	@Override
	public int userRegDao(User u) {
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
			String sql = "insert into test2 value(default,?,?,?,?,?)";
			// 创建sql命令对象
			ps = conn.prepareStatement(sql);
			// 给占位符赋值
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getSex());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getBirth());
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
