package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.ClazzDao;
import com.ischoolbar.programmer.dao.PjglDao;
import com.ischoolbar.programmer.entity.Pjgl;
import com.ischoolbar.programmer.service.PjglService;
@Service
public class PjglServiceImpl implements PjglService {

	@Autowired
	private PjglDao pjglDao;
	
	@Override
	public int add(Pjgl pjgl) {
		// TODO Auto-generated method stub
		return pjglDao.add(pjgl);
	}

	@Override
	public int edit(Pjgl pjgl) {
		// TODO Auto-generated method stub
		return pjglDao.edit(pjgl);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return pjglDao.delete(ids);
	}

	@Override
	public List<Pjgl> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return pjglDao.findList(queryMap);
	}

	@Override
	public List<Pjgl> findAll() {
		// TODO Auto-generated method stub
		return pjglDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return pjglDao.getTotal(queryMap);
	}

	@Override
	public int studentEdit(Pjgl pjgl) {
		// TODO Auto-generated method stub
		return pjglDao.studentEdit(pjgl);
	}

}
