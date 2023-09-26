package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.ProcesssDao;
import com.ischoolbar.programmer.entity.Processs;
import com.ischoolbar.programmer.service.ProcesssService;
@Service
public class ProcesssServiceImpl implements ProcesssService {

	@Autowired
	private ProcesssDao processsDao;
	
	@Override
	public int add(Processs processs) {
		// TODO Auto-generated method stub
		return processsDao.add(processs);
	}

	@Override
	public int edit(Processs processs) {
		// TODO Auto-generated method stub
		return processsDao.edit(processs);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return processsDao.delete(ids);
	}

	@Override
	public List<Processs> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return processsDao.findList(queryMap);
	}

	@Override
	public List<Processs> findAll() {
		// TODO Auto-generated method stub
		return processsDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return processsDao.getTotal(queryMap);
	}

}
