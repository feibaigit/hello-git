package com.aa.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.aa.common.utils.EasyUIDataGridResult;
import com.aa.pojo.Student;


public interface StudentService {
	
	int insert(Student student);

	int updateById(Map<String, Object> paramMap);

	Student getById(Integer id);
	
	EasyUIDataGridResult listStudent(Integer page, Integer rows);
	
	int delete(Integer id);
}
