package com.aa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.common.utils.EasyUIDataGridResult;
import com.aa.mapper.StudentMapper;
import com.aa.pojo.Student;
import com.aa.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;
	
	public int insert(Student student) {
		int i = studentMapper.save(student);
		return i;
	}

	public int updateById(Map<String, Object> paramMap) {
		int i = studentMapper.updateSelective(paramMap);
		return i;
	}

	public Student getById(Integer id) {
		studentMapper.findByPrimary(id);
		return null;
	}

	public EasyUIDataGridResult listStudent(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<Student> list = studentMapper.listSelective(paramMap);
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		
		PageInfo<Student> pageInfo = new PageInfo<Student>(list);
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;
	}

	public int delete(Integer id) {
		return studentMapper.delete(id);
	}
	
	

}
