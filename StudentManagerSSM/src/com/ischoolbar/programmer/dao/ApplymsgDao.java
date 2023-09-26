package com.ischoolbar.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.Applymsg;

/**
 * 招聘公司信息dao
 * @author zjj
 *
 */
@Repository
public interface ApplymsgDao {
	public int add(Applymsg applymsg);
	public int edit(Applymsg applymsg);
	public int delete(String ids);
	public List<Applymsg> findList(Map<String,Object> queryMap);
	public List<Applymsg> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}

