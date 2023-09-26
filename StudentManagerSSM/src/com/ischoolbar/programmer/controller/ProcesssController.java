package com.ischoolbar.programmer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.Processs;
import com.ischoolbar.programmer.entity.Student;
import com.ischoolbar.programmer.page.Page;
import com.ischoolbar.programmer.service.ProcesssService;
import com.ischoolbar.programmer.service.StudentService;

import net.sf.json.JSONArray;
/**
 * ʵϰ�����б�
 * @author zjj
 *
 */
@RequestMapping("/processs")
@Controller
public class ProcesssController {
	
	@Autowired
	private ProcesssService processsService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("processs/processs_list");
		List<Student> studentList = studentService.findAll();
		model.addObject("studentList",studentList );
		model.addObject("studentListJson",JSONArray.fromObject(studentList));
		return model;
	}
	
	
	/***
	 *  ��ȡʵϰ�����б�
	 * @param sdId
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(
			@RequestParam(value="sdId",required=false,defaultValue="")String sdId,
			HttpServletRequest request,
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("sdId","%"+sdId+"%");
		Object attribute = request.getSession().getAttribute("userType");
		if("2".equals(attribute.toString())){
			//˵����ѧ��
			Student loginedStudent = (Student)request.getSession().getAttribute("user");
			queryMap.put("sdId",loginedStudent.getUsername());
		}
		queryMap.put("offset",page.getOffset());
		queryMap.put("pageSize",page.getRows());
		ret.put("rows", processsService.findList(queryMap));
		ret.put("total",processsService.getTotal(queryMap));
		return ret;
	}
	
	/***
	 * ��� ʵϰ������Ϣ
	 * @param processs
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> add(Processs processs){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(processs)) {
			ret.put("type", "error");
			ret.put("msg","ѧ��������ֹΪ�գ�");
			return ret;
		}
		if(processsService.add(processs)<=0) {
			ret.put("type", "error");
			ret.put("msg","���ʧ�ܣ�");
			return ret;
		}
		ret.put("type","success");
		ret.put("msg","��ӳɹ�");
		return ret;
	}
	
	/**
	 * �༭ʵϰ������Ϣ
	 * @param processs
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> edit(Processs processs){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(processs.getSdId())) {
			ret.put("type", "error");
			ret.put("msg","ѧ��������ֹΪ�գ�");
			return ret;
		}
		if(processsService.edit(processs)<=0) {
			ret.put("type", "error");
			ret.put("msg","�޸�ʧ�ܣ�");
			return ret;
		}
		ret.put("type","success");
		ret.put("msg","�޸ĳɹ�");
		return ret;
	}
	
	/**
	 * ɾ��ʵϰ������Ϣ
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(
			@RequestParam(value="ids[]",required=true) Long[] ids
		){
		Map<String, String> ret = new HashMap<String, String>();
		if(ids == null){
			ret.put("type", "error");
			ret.put("msg", "��ѡ��Ҫɾ��������!");
			return ret;
		}
		String idsString = "";
		for(Long id:ids){
			idsString += id + ",";
		}
		idsString = idsString.substring(0,idsString.length()-1);
		if(processsService.delete(idsString) <= 0){
			ret.put("type", "error");
			ret.put("msg", "ɾ��ʧ��!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "ɾ���ɹ�!");
		return ret;
	}
	
}
