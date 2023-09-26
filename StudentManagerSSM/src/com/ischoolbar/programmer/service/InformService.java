package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Inform;

/**
 * ʵϰ֪ͨservice
 * @author zjj
 *
 */
@Service
public interface InformService {
	public int add(Inform inform);
	public int edit(Inform inform);
	public int delete(String ids);
	public List<Inform> findList(Map<String,Object> queryMap);
	public List<Inform> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}
