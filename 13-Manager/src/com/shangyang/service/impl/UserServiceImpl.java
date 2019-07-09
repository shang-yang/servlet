package com.shangyang.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.shangyang.dao.UserDao;
import com.shangyang.dao.impl.UserDaoImpl;
import com.shangyang.pojo.User;
import com.shangyang.service.UserService;

public class UserServiceImpl implements UserService{

	// 声明日志对象
	Logger logger = LogManager.getLogger(UserServiceImpl.class);
	// 声明Dao层对象
	UserDao ud = new UserDaoImpl();
	
	// 用户登录
	@Override
	public User checkUserLoginService(String uname, String pwd) {
		// 打印日志
		logger.debug(uname + "发起登录请求");
		User u = ud.checkUserLoginDao(uname, pwd);
		// 判断
		if(u != null) {
			logger.debug(uname + "登录成功");
		} else {
			logger.debug(uname + "登录失败");
		}
		return u;
	}

	@Override
	public int userChangePwdService(String newPwd, int uid) {
		logger.debug(uid + "发起密码修改请求");
		int index =  ud.userChangePwdDao(newPwd,uid);
		if(index > 0) {
			logger.debug(uid + "密码修改成功");
		} else {
			logger.debug(uid + "密码修改失败");
		} 
		return index;
	}

	@Override
	public List<User> userShowService() {
		List<User> lu = ud.userShowDao();
		logger.debug("显示所有用户信息" + lu);
		return lu;
	}

	@Override
	public int userRegService(User u) {
		// TODO Auto-generated method stub
		return ud.userRegDao(u);
	}

	
}
