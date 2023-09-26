package com.ischoolbar.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.Inform;

/**
 * ֪ͨdao
 * @author zjj
 *
 */
@Repository
public interface InformDao {
	public int add(Inform inform);
	public int edit(Inform inform);
	public int delete(String ids);
	public List<Inform> findList(Map<String,Object> queryMap);
	public List<Inform> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}

