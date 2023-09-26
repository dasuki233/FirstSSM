package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Independent;
import com.ischoolbar.programmer.entity.Volunteer;

/**
 * ÷æ‘∏…Í«Îservice
 * @author zjj
 *
 */
@Service
public interface VolunteerService {
	public int add(Volunteer volunteer);
	public int edit(Volunteer volunteer);
	public int delete(String ids);
	public List<Volunteer> findList(Map<String,Object> queryMap);
	public List<Volunteer> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}
