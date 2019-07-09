package com.shangyang.service;

import java.util.List;

import com.shangyang.pojo.Flower;

public interface FlowerService {

	/**
	 * 显示所有花卉信息
	 * @return
	 */
	List<Flower> show();
	
	/**
	 * 添加
	 * @return
	 */
	int add(Flower flower);
}
