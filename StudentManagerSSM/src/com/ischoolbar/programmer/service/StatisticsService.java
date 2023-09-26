package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Statistics;
import com.ischoolbar.programmer.entity.Student;

/**
 *统计与分析service
 * @author zjj
 *
 */
@Service
public interface StatisticsService {
	public List<Statistics> findList(Map<String,Object> queryMap);
	public List<Student> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	public int count();
}
