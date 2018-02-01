package com.aa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aa.common.utils.EasyUIDataGridResult;
import com.aa.common.utils.TaotaoResult;
import com.aa.pojo.Student;
import com.aa.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/stu/list")
	@ResponseBody
	public EasyUIDataGridResult findItem(Integer page,Integer rows){

		EasyUIDataGridResult result = studentService.listStudent(page, rows);
		
		return result;
	}
	
	@RequestMapping("/stu/delete")
	@ResponseBody
	public TaotaoResult delete(@RequestParam("id") Integer id  ){
		int i = studentService.delete(id);
		TaotaoResult taotao = new TaotaoResult();
		if(i>0){
			taotao.setData(i);
			taotao.setMsg("删除成功");
			taotao.setStatus(200);
		}
		return taotao;
	}
	
	@RequestMapping("/stu/add")
	@ResponseBody
	public TaotaoResult addStu(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("trueName") String trueName,
			@RequestParam("stuNo") String stuNo,
			@RequestParam("professional") String professional
			){
		
		Student stu = new Student();
		stu.setUserName(userName);
		stu.setPassword(password);
		stu.setTrueName(trueName);
		stu.setStuNo(stuNo);
		stu.setProfessional(professional);
		
		int i = studentService.insert(stu);
		return TaotaoResult.ok(); 
	}
	
	@RequestMapping("/stu/update")
	@ResponseBody
	public TaotaoResult updateStu(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("trueName") String trueName,
			@RequestParam("stuNo") String stuNo,
			@RequestParam("professional") String professional,
			@RequestParam("id") String id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("userName", userName);
		map.put("password", password);
		map.put("trueName", trueName);
		map.put("stuNo", stuNo);
		map.put("professional", professional);
		int i = studentService.updateById(map);
		return TaotaoResult.ok(); 
	}
}
