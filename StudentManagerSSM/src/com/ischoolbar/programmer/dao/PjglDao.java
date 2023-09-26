package com.ischoolbar.programmer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ischoolbar.programmer.entity.Pjgl;

/**
 * ∆¿º€π‹¿Ìdao
 * @author zjj
 *
 */
@Repository
public interface PjglDao {
	public int add(Pjgl pjgl);
	public int edit(Pjgl pjgl);
	public int delete(String ids);
	public List<Pjgl> findList(Map<String,Object> queryMap);
	public List<Pjgl> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	public int studentEdit(Pjgl  pjgl);
	
}

