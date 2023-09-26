package com.ischoolbar.programmer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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

import com.ischoolbar.programmer.entity.Pjgl;
import com.ischoolbar.programmer.entity.Student;
import com.ischoolbar.programmer.page.Page;
import com.ischoolbar.programmer.service.PjglService;
import com.ischoolbar.programmer.service.StudentService;
import com.ischoolbar.programmer.util.StringUtil;
import net.sf.json.JSONArray;

/**
 * ���۹���
 * @author zjj
 *
 */
@RequestMapping("/pjgl")
@Controller
public class PjglController {
	
	@Autowired
	private PjglService pjglService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("pjgl/pjgl_list");
		List<Student> studentList = studentService.findAll();
		model.addObject("studentList",studentList );
		model.addObject("studentListJson",JSONArray.fromObject(studentList));
		return model;
	}
	
	/**
	 * ��ȡ���۹����б�
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
		ret.put("rows", pjglService.findList(queryMap));
		ret.put("total",pjglService.getTotal(queryMap));
		return ret;
	}
	
	/**
	 * ��� ���۹�����Ϣ
	 * @param pjgl
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> add(Pjgl pjgl){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(pjgl.getSdId())) {
			ret.put("type", "error");
			ret.put("msg","ѧ��������ֹΪ�գ�");
			return ret;
		}
		
		if(pjglService.add(pjgl)<=0) {
			ret.put("type", "error");
			ret.put("msg","���ʧ�ܣ�");
			return ret;
		}
		ret.put("type","success");
		ret.put("msg","��ӳɹ�");
		return ret;
	}
	
	/**
	 * �༭���۹�����Ϣ
	 * @param pjgl
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> edit(Pjgl pjgl){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(pjgl.getSdId())) {
			ret.put("type", "error");
			ret.put("msg","ѧ��������ֹΪ�գ�");
			return ret;
		}
		if(pjglService.edit(pjgl)<=0) {
			ret.put("type", "error");
			ret.put("msg","�޸�ʧ�ܣ�");
			return ret;
		}
		ret.put("type","success");
		ret.put("msg","�޸ĳɹ�");
		return ret;
	}
	@RequestMapping(value="/studentEdit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> StudentEdit(Pjgl pjgl){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(pjgl.getSdId())) {
			ret.put("type", "error");
			ret.put("msg","ѧ��������ֹΪ�գ�");
			return ret;
		}
		if(pjglService.studentEdit(pjgl)<=0) {
			ret.put("type", "error");
			ret.put("msg","�޸�ʧ�ܣ�");
			return ret;
		}
		ret.put("type","success");
		ret.put("msg","�޸ĳɹ�");
		return ret;
	}
	
	/**
	 * ɾ�����۹�����Ϣ
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
		if(pjglService.delete(idsString) <= 0){
			ret.put("type", "error");
			ret.put("msg", "ɾ��ʧ��!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "ɾ���ɹ�!");
		return ret;
	}
	
	
}
