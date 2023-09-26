package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Clazz;
import com.ischoolbar.programmer.entity.Inform;
import com.ischoolbar.programmer.entity.Units;

/**
 * 单位信息service
 * @author zjj
 *
 */
@Service
public interface UnitsService {
	public int add(Units units);
	public int edit(Units units);
	public int delete(String ids);
	public List<Units> findList(Map<String,Object> queryMap);
	public List<Units> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}
