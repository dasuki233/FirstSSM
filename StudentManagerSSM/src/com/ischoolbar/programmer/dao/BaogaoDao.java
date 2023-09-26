package com.ischoolbar.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.Baogao;

/**
 * 变更实习单位报告dao
 * @author zjj
 *
 */
@Repository
public interface BaogaoDao {
	public int add(Baogao baogao);
	public int edit(Baogao baogao);
	public int delete(String ids);
	public List<Baogao> findList(Map<String,Object> queryMap);
	public List<Baogao> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}

