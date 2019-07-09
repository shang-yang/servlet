package com.shangyang.service.impl;

import java.util.List;

import com.shangyang.dao.FlowerDao;
import com.shangyang.dao.impl.FlowerDaoImpl;
import com.shangyang.pojo.Flower;
import com.shangyang.service.FlowerService;

public class FlowerServiceImpl implements FlowerService{

	private FlowerDao flowerDao = new FlowerDaoImpl();
	
	@Override
	public List<Flower> show() {
		// TODO Auto-generated method stub
		return flowerDao.selAll();
	}
	
	@Override
	public int add(Flower flower) {
		return flowerDao.insFlower(flower);
	}
}
