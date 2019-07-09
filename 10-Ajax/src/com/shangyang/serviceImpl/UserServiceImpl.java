package com.shangyang.serviceImpl;

import com.shangyang.dao.UserDao;
import com.shangyang.daoImpl.UserDaoImpl;
import com.shangyang.pojo.User;
import com.shangyang.service.UserService;

public class UserServiceImpl implements UserService {

	// 获取Dao层对象
	UserDao ud = new UserDaoImpl();
	
	
	@Override
	public User getUserInfoService(String name) {
		// TODO Auto-generated method stub
		return ud.getUserInfo(name);
	}

}
