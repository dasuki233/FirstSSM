package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.UnitsDao;
import com.ischoolbar.programmer.entity.Units;
import com.ischoolbar.programmer.service.UnitsService;

@Service
public class UnitsServiceImpl implements UnitsService {

	@Autowired
	private UnitsDao unitsDao;
	
	@Override
	public int add(Units units) {
		// TODO Auto-generated method stub
		return unitsDao.add(units);
	}

	@Override
	public int edit(Units units) {
		// TODO Auto-generated method stub
		return unitsDao.edit(units);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return unitsDao.delete(ids);
	}

	@Override
	public List<Units> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return unitsDao.findList(queryMap);
	}

	@Override
	public List<Units> findAll() {
		// TODO Auto-generated method stub
		return unitsDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return unitsDao.getTotal(queryMap);
	}

}
