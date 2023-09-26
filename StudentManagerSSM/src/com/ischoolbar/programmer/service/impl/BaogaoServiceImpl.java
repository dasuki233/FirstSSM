package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.BaogaoDao;
import com.ischoolbar.programmer.entity.Baogao;
import com.ischoolbar.programmer.service.BaogaoService;
@Service
public class BaogaoServiceImpl implements BaogaoService {

	@Autowired
	private BaogaoDao baogaoDao;
	
	@Override
	public int add(Baogao baogao) {
		// TODO Auto-generated method stub
		return baogaoDao.add(baogao);
	}

	@Override
	public int edit(Baogao baogao) {
		// TODO Auto-generated method stub
		return baogaoDao.edit(baogao);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return baogaoDao.delete(ids);
	}

	@Override
	public List<Baogao> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return baogaoDao.findList(queryMap);
	}

	@Override
	public List<Baogao> findAll() {
		// TODO Auto-generated method stub
		return baogaoDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return baogaoDao.getTotal(queryMap);
	}

}
