package com.aa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aa.common.pojo.EasyUIDataGridResult;
import com.aa.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@ResponseBody
	@RequestMapping("/list")
	public EasyUIDataGridResult findItem(Integer page,Integer rows){
		EasyUIDataGridResult result = itemService.findByPage(page, rows);
		return result;
	}
}
