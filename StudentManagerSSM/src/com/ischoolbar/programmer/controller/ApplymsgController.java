package com.ischoolbar.programmer.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.Applymsg;
import com.ischoolbar.programmer.page.Page;
import com.ischoolbar.programmer.service.ApplymsgService;
import com.ischoolbar.programmer.util.StringUtil;

import net.sf.json.JSONArray;
/**
 * ��Ƹ��˾��Ϣ����
 * @author zjj
 *
 */
@RequestMapping("/applymsg")
@Controller
public class ApplymsgController {
	
	@Autowired
	private ApplymsgService applymsgService;
	
	/**
	 * ��Ƹ��˾��Ϣ֪ͨҳ
	 * @author zjj
	 *
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("applymsg/applymsg_list");
		return model;
	}
	
	
	/**
	 *  ��Ƹ��˾��Ϣ�б�
	 * @param name
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(
			@RequestParam(value="name",required=false,defaultValue="") String name,
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("name","%"+name+"%");
		queryMap.put("offset",page.getOffset());
		queryMap.put("pageSize",page.getRows());
		ret.put("rows", applymsgService.findList(queryMap));
		ret.put("total",applymsgService.getTotal(queryMap));
		return ret;
	}
	
	
	/**
	 *  �����Ƹ��˾��Ϣ
	 * @param applymsg
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> add(Applymsg applymsg){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(applymsg.getName())) {
			ret.put("type", "error");
			ret.put("msg","��λ���ƽ�ֹΪ�գ�");
			return ret;
		}
		if(applymsgService.add(applymsg)<=0) {
			ret.put("type", "error");
			ret.put("msg","���ʧ�ܣ�");
			return ret;
		}
		ret.put("type","success");
		ret.put("msg","��ӳɹ�");
		return ret;
	}
	
	/***
	 * �༭��Ƹ��˾��Ϣ
	 * @param applymsg
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> edit(Applymsg applymsg){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(applymsg.getName())) {
			ret.put("type", "error");
			ret.put("msg","��λ���ƽ�ֹΪ�գ�");
			return ret;
		}
		if(applymsgService.edit(applymsg)<=0) {
			ret.put("type", "error");
			ret.put("msg","�޸�ʧ�ܣ�");
			return ret;
		}
		ret.put("type","success");
		ret.put("msg","�޸ĳɹ�");
		return ret;
	}
	
	/**
	 * ɾ����Ϣ��Ƹ��˾��Ϣ
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(
			@RequestParam(value="ids[]",required=true) Long[] ids
			){
		Map<String, String> ret = new HashMap<String, String>();
		if(ids == null || ids.length == 0){
			ret.put("type", "error");
			ret.put("msg", "��ѡ��Ҫɾ�������ݣ�");
			return ret;
		}
		try {
			if(applymsgService.delete(StringUtil.joinString(Arrays.asList(ids), ",")) <= 0){
				ret.put("type", "error");
				ret.put("msg", "ɾ��ʧ�ܣ�");
				return ret;
			}
		} catch (Exception e) {
			// TODO: handle exception
			ret.put("type", "error");
			ret.put("msg", "�������¿��ܴ����������ݣ���ȷ�Ϻ���в�����");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "ɾ���ɹ���");
		return ret;
	}
	
}
