package com.ischoolbar.programmer.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.dao.PjglDao;
import com.ischoolbar.programmer.dao.StatisticsDao;
import com.ischoolbar.programmer.entity.Statistics;
import com.ischoolbar.programmer.entity.Student;
import com.ischoolbar.programmer.service.StatisticsService;
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private StatisticsDao statisticsDao;
	
	@Override
	public List<Statistics> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return statisticsDao.findList(queryMap);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return statisticsDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return statisticsDao.getTotal(queryMap);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
