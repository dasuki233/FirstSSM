package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.ApplymsgDao;
import com.ischoolbar.programmer.entity.Applymsg;
import com.ischoolbar.programmer.service.ApplymsgService;
@Service
public class ApplymsgServiceImpl implements ApplymsgService {

	@Autowired
	private ApplymsgDao applymsgDao;
	
	@Override
	public int add(Applymsg applymsg) {
		// TODO Auto-generated method stub
		return applymsgDao.add(applymsg);
	}

	@Override
	public int edit(Applymsg applymsg) {
		// TODO Auto-generated method stub
		return applymsgDao.edit(applymsg);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return applymsgDao.delete(ids);
	}

	@Override
	public List<Applymsg> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return applymsgDao.findList(queryMap);
	}

	@Override
	public List<Applymsg> findAll() {
		// TODO Auto-generated method stub
		return applymsgDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return applymsgDao.getTotal(queryMap);
	}

}
