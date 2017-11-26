package com.aa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@RequestMapping("/")
	public String page(){
		
		return "index";
	}
	@RequestMapping(value="{page}")
	public String topage(@PathVariable String page){
		return page;
	}
}
