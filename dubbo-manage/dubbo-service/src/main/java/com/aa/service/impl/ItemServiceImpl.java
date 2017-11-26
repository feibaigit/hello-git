package com.aa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aa.common.pojo.EasyUIDataGridResult;
import com.aa.mapper.TbItemMapper;
import com.aa.pojo.TbItem;
import com.aa.pojo.TbItemExample;
import com.aa.pojo.TbItemExample.Criteria;
import com.aa.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public EasyUIDataGridResult findByPage(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		TbItemExample example = new TbItemExample();
		//Criteria criteria = example.createCriteria();
		List<TbItem> list = itemMapper.selectByExample(example);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		
		//得到记录总数
		
		PageInfo<TbItem> info = new PageInfo<>(list);
		long total = info.getTotal();
		result.setTotal(total);
		return result;
	}

}
