package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.IndependentDao;
import com.ischoolbar.programmer.entity.Independent;
import com.ischoolbar.programmer.service.IndependentService;
import com.ischoolbar.programmer.dao.InformDao;
import com.ischoolbar.programmer.entity.Clazz;
import com.ischoolbar.programmer.entity.Inform;
import com.ischoolbar.programmer.service.InformService;
@Service
public class IndependentImpl implements IndependentService {

	@Autowired
	private IndependentDao independentDao;
	
	@Override
	public int add(Independent independent) {
		// TODO Auto-generated method stub
		return independentDao.add(independent);
	}

	@Override
	public int edit(Independent independent) {
		// TODO Auto-generated method stub
		return independentDao.edit(independent);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return independentDao.delete(ids);
	}

	@Override
	public List<Independent> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return independentDao.findList(queryMap);
	}

	@Override
	public List<Independent> findAll() {
		// TODO Auto-generated method stub
		return independentDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return independentDao.getTotal(queryMap);
	}

}
