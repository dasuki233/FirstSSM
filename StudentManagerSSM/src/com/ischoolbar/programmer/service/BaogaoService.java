package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Baogao;

/**
 * ���ʵϰ��λ����service
 * @author zjj
 *
 */
@Service
public interface BaogaoService {
	public int add(Baogao baogao);
	public int edit(Baogao baogao);
	public int delete(String ids);
	public List<Baogao> findList(Map<String,Object> queryMap);
	public List<Baogao> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}
