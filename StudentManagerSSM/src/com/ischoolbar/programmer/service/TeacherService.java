package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Teacher;

/**
 * ¿œ ¶service
 * @author zjj
 *
 */
@Service
public interface TeacherService {
	public Teacher findByTeacherName(String username);
	public int add(Teacher teacher);
	public int edit(Teacher teacher);
	public int delete(String ids);
	public List<Teacher> findList(Map<String,Object> queryMap);
	public List<Teacher> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	
	
}
