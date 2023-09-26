package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.InformDao;
import com.ischoolbar.programmer.entity.Clazz;
import com.ischoolbar.programmer.entity.Inform;
import com.ischoolbar.programmer.service.InformService;
@Service
public class InformServiceImpl implements InformService {

	@Autowired
	private InformDao informDao;
	

	@Override
	public int add(Inform inform) {
		// TODO Auto-generated method stub
		return informDao.add(inform);
	}

	@Override
	public int edit(Inform inform) {
		// TODO Auto-generated method stub
		return informDao.edit(inform);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return informDao.delete(ids);
	}

	@Override
	public List<Inform> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return informDao.findList(queryMap);
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return informDao.getTotal(queryMap);
	}

	@Override
	public List<Inform> findAll() {
		// TODO Auto-generated method stub
		return informDao.findAll();
	}


}
