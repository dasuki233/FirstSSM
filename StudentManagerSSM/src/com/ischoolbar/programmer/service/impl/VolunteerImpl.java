package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.IndependentDao;
import com.ischoolbar.programmer.dao.VolunteerDao;
import com.ischoolbar.programmer.entity.Volunteer;
import com.ischoolbar.programmer.service.VolunteerService;
@Service
public class VolunteerImpl implements VolunteerService {
	
	@Autowired
	private VolunteerDao volunteerDao;

	@Override
	public int add(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerDao.add(volunteer);
	}

	@Override
	public int edit(Volunteer volunteer) {
		// TODO Auto-generated method stub
		return volunteerDao.edit(volunteer);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return volunteerDao.delete(ids);
	}

	@Override
	public List<Volunteer> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return volunteerDao.findList(queryMap);
	}

	@Override
	public List<Volunteer> findAll() {
		// TODO Auto-generated method stub
		return volunteerDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return volunteerDao.getTotal(queryMap);
	}

}
