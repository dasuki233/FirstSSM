package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Independent;

/**
 * ×ÔÔ¸ÉêÇëservice
 * @author zjj
 *
 */
@Service
public interface IndependentService {
	public int add(Independent independent);
	public int edit(Independent independent);
	public int delete(String ids);
	public List<Independent> findList(Map<String,Object> queryMap);
	public List<Independent> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}
