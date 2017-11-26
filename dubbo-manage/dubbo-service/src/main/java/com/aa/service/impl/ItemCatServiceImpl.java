package com.aa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.common.pojo.EasyTreeNode;
import com.aa.mapper.TbItemCatMapper;
import com.aa.pojo.TbItemCat;
import com.aa.pojo.TbItemCatExample;
import com.aa.pojo.TbItemCatExample.Criteria;
import com.aa.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyTreeNode> findItemCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<TbItemCat> itemCats = itemCatMapper.selectByExample(example);
		List<EasyTreeNode>  nodes = new ArrayList<>();
		for(TbItemCat itemCat:itemCats){
			EasyTreeNode node = new EasyTreeNode();
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			node.setState(itemCat.getIsParent()?"closed":"open");
			
			nodes.add(node);
		}
		return nodes;
	}

}
