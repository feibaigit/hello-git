package com.aa.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;


public interface BaseMapper<T> {

	public int save(T e);
	
	public int updateSelective(Map<String, Object> paramMap);
	
	T findByPrimary(Integer id);
	
	List<T> listSelective(Map<String, Object> paramMap);
	
	int delete(Integer id);
}
