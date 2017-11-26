package com.aa.service;

import com.aa.common.pojo.EasyUIDataGridResult;

public interface ItemService {

	//分页查询商品
	EasyUIDataGridResult findByPage(Integer page,Integer rows);
}
