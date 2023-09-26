package com.ischoolbar.programmer.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.ischoolbar.programmer.entity.Pjgl;

/**
 * ∆¿º€π‹¿Ìservice
 * @author zjj
 *
 */
@Service
public interface PjglService {
	public int add(Pjgl  pjgl);
	public int edit(Pjgl  pjgl);
	public int delete(String ids);
	public List<Pjgl> findList(Map<String,Object> queryMap);
	public List<Pjgl> findAll();
	public int  getTotal(Map<String,Object> queryMap);
	public int studentEdit(Pjgl  pjgl);
	
}
