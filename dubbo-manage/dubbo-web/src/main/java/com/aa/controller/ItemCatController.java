package com.aa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aa.common.pojo.EasyTreeNode;
import com.aa.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyTreeNode> findItemCat(@RequestParam(value="id",defaultValue="0") Long parentId){
		List<EasyTreeNode> result = itemCatService.findItemCatList(parentId);
		return result;
	}
}
