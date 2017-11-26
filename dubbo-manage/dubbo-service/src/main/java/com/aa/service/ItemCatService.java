package com.aa.service;

import java.util.List;

import com.aa.common.pojo.EasyTreeNode;

public interface ItemCatService {

	//查询商品分类，根据分类的id
	List<EasyTreeNode> findItemCatList(long parentId);

}
