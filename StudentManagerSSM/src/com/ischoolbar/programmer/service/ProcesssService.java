package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Processs;

/**
 * ÊµÏ°¹ý³Ìservice
 * @author zjj
 *
 */
@Service
public interface ProcesssService {
	public int add(Processs processs);
	public int edit(Processs processs);
	public int delete(String ids);
	public List<Processs> findList(Map<String,Object> queryMap);
	public List<Processs> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}
