package com.ischoolbar.programmer.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.Inform;
import com.ischoolbar.programmer.entity.Student;
import com.ischoolbar.programmer.page.Page;
import com.ischoolbar.programmer.service.InformService;
import com.ischoolbar.programmer.service.StudentService;
import com.ischoolbar.programmer.util.StringUtil;

import net.sf.json.JSONArray;
/**
 * ֪ͨ����
 * @author zjj
 *
 */
@RequestMapping("/inform")
@Controller
public class InformController {
	
	@Autowired
	private InformService informService;
	@Autowired
	private StudentService studentService;
	
	/**
	 * ����ʵϰ֪ͨҳ
	 * @author zjj
	 *
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("inform/inform_list");
		List<Student> findAll = studentService.findAll();
		model.addObject("studentList",findAll );
		model.addObject("studentListJson",JSONArray.fromObject(findAll));
		return model;
	}
	
	
	/***
	 * ��ȡ֪ͨʱ���б�
	 * @param arrange
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(
			@RequestParam(value="studentId",required=false,defaultValue="") String studentId,
			HttpServletRequest request,
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("studentId","%"+studentId+"%");
		Object attribute = request.getSession().getAttribute("userType");
		if("2".equals(attribute.toString())){
			//˵����ѧ��
			Student loginedStudent = (Student)request.getSession().getAttribute("user");
			queryMap.put("studentId", loginedStudent.getUsername());
		}
		queryMap.put("offset",page.getOffset());
		queryMap.put("pageSize",page.getRows());
		ret.put("rows", informService.findList(queryMap));
		ret.put("total",informService.getTotal(queryMap));
		return ret;
	}
	
	
	/***
	 * ���
	 * @param inform
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> add(Inform inform){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(inform.getStudentId())) {
			ret.put("type", "error");
			ret.put("msg","������ֹΪ�գ�");
			return ret;
		}
		if(informService.add(inform)<=0) {
			ret.put("type", "error");
			ret.put("msg","���ʧ�ܣ�");
		}
		ret.put("type","success");
		ret.put("msg","��ӳɹ�");
		return ret;
	}
	
	/***
	 * �༭֪ͨ
	 * @param inform
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> edit(Inform inform){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(inform.getStudentId())) {
			ret.put("type", "error");
			ret.put("msg","������ֹΪ�գ�");
			return ret;
		}
		if(informService.edit(inform)<=0) {
			ret.put("type", "error");
			ret.put("msg","�޸�ʧ�ܣ�");
		}
		ret.put("type","success");
		ret.put("msg","�޸ĳɹ�");
		return ret;
	}
	
	/**
	 * ɾ����Ϣ
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
			if(informService.delete(StringUtil.joinString(Arrays.asList(ids), ",")) <= 0){
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
