package com.shangyang.impl;

import com.shangyang.dao.LoginDao;
import com.shangyang.dao.impl.LoginDaoImpl;
import com.shangyang.pojo.User;
import com.shangyang.service.LoginService;

public class LoginServiceImpl implements LoginService{

	// 创建Dao层对象
	LoginDao Id = new LoginDaoImpl();
	
	// 校验用户登录信息
	@Override
	public User checkLoginService(String uname, String pwd) {
		return Id.checkLoginDao(uname, pwd);
	}
	
	// 校验用户Cookie信息
	@Override
	public User checkUidService(String uid) {
		
		return Id.checkUidDao(uid);
	}
}
