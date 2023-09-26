package com.ischoolbar.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.Student;
import com.ischoolbar.programmer.entity.Teacher;
import com.ischoolbar.programmer.entity.User;

/**
 * ΩÃ ¶dao
 * @author zjj
 *
 */
@Repository
public interface TeacherDao {
	public Teacher findByTeacherName(String username);
	public int add(Teacher teacher);
	public int edit(Teacher teacher);
	public int delete(String ids);
	public List<Teacher> findList(Map<String,Object> queryMap);
	public List<Teacher> findAll();
	public int  getTotal(Map<String,Object> queryMap);
}

