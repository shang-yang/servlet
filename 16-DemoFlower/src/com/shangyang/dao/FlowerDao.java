package com.shangyang.dao;

import java.util.List;

import com.shangyang.pojo.Flower;

public interface FlowerDao {

	/**
	 * 查询全部
	 * @return
	 */
	List<Flower> selAll();
	
	/**
	 * 新增
	 * @param flower
	 * @return
	 */
	int insFlower(Flower flower);
}
