package com.ischoolbar.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.Clazz;
import com.ischoolbar.programmer.entity.Independent;
import com.ischoolbar.programmer.entity.Inform;
import com.ischoolbar.programmer.entity.Units;

/**
 * ×ÔÖ÷ÊµÏ°dao
 * @author zjj
 *
 */
@Repository
public interface IndependentDao {
	public int add(Independent independent);
	public int edit(Independent independent);
	public int delete(String ids);
	public List<Independent> findList(Map<String,Object> queryMap);
	public List<Independent> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}

