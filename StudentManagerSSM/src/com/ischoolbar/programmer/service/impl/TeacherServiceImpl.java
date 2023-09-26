package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.TeacherDao;
import com.ischoolbar.programmer.entity.Teacher;
import com.ischoolbar.programmer.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;
	@Override
	public Teacher findByTeacherName(String username) {
		// TODO Auto-generated method stub
		return teacherDao.findByTeacherName(username);
	}
	@Override
	public int add(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.add(teacher);
	}
	@Override
	public List<Teacher> findList(Map queryMap) {
		// TODO Auto-generated method stub
		return teacherDao.findList(queryMap);
	}
	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return teacherDao.getTotal(queryMap);
	}
	@Override
	public int edit(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.edit(teacher);
	}
	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return teacherDao.delete(ids);
	}
	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		return teacherDao.findAll();
	}

}
