package com.ischoolbar.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.Clazz;
import com.ischoolbar.programmer.entity.Independent;
import com.ischoolbar.programmer.entity.Inform;
import com.ischoolbar.programmer.entity.Units;
import com.ischoolbar.programmer.entity.Volunteer;

/**
 * ־Ըʵϰdao
 * @author zjj
 *
 */
@Repository
public interface VolunteerDao {
	public int add(Volunteer volunteer);
	public int edit(Volunteer volunteer);
	public int delete(String ids);
	public List<Volunteer> findList(Map<String,Object> queryMap);
	public List<Volunteer> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}

