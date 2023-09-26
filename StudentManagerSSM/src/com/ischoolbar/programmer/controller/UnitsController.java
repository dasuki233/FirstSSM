package com.ischoolbar.programmer.controller;

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

import com.ischoolbar.programmer.entity.Student;
import com.ischoolbar.programmer.entity.Teacher;
import com.ischoolbar.programmer.entity.Units;
import com.ischoolbar.programmer.page.Page;
import com.ischoolbar.programmer.service.StudentService;
import com.ischoolbar.programmer.service.TeacherService;
import com.ischoolbar.programmer.service.UnitsService;
import com.ischoolbar.programmer.util.StringUtil;

import net.sf.json.JSONArray;
/**
 * 实习单位信息
 * @author zjj
 *
 */
@RequestMapping("/units")
@Controller
public class UnitsController {
	
	@Autowired
	private UnitsService unitsService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	/**
	 * 实习单位列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("units/units_list");
		 List<Student> studentList = studentService.findAll();
		 List<Teacher> teacherList = teacherService.findAll();
	     model.addObject("studentList",studentList );
		 model.addObject("studentListJson",JSONArray.fromObject(studentList));
		 model.addObject("teacherList",teacherList );
		 model.addObject("teacherListJson",JSONArray.fromObject(teacherList));
		 return model;
	}
	
	/***
	 * 实习单位信息列表
	 * @param arrange
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
			//说明是学生
			Student loginedStudent = (Student)request.getSession().getAttribute("user");
			queryMap.put("sdId", loginedStudent.getUsername());
		}
		queryMap.put("offset",page.getOffset());
		queryMap.put("pageSize",page.getRows());
		ret.put("rows", unitsService.findList(queryMap));
		ret.put("total",unitsService.getTotal(queryMap));
		return ret;
	}
	
	/***
	 * 添加实习单位信息
	 * @param units
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> add(Units units){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(units.getSdId())) {
			ret.put("type", "error");
			ret.put("msg","学生姓名禁止为空！");
			return ret;
		}
		if(StringUtils.isEmpty(units.getTcId())) {
			ret.put("type", "error");
			ret.put("msg","指导老师禁止为空！");
			return ret;
		}
		if(unitsService.add(units)<=0) {
			ret.put("type", "error");
			ret.put("msg","添加失败！");
		}
		ret.put("type","success");
		ret.put("msg","添加成功");
		return ret;
	}
	
	/***
	 * 编辑实习单位信息
	 * @param units
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> edit(Units units){
		Map<String, String> ret = new HashMap<String, String>();
		if(StringUtils.isEmpty(units.getSdId())) {
			ret.put("type", "error");
			ret.put("msg","学生姓名禁止为空！");
			return ret;
		}
		if(StringUtils.isEmpty(units.getTcId())) {
			ret.put("type", "error");
			ret.put("msg","指导老师禁止为空！");
			return ret;
		}
		if(unitsService.edit(units)<=0) {
			ret.put("type", "error");
			ret.put("msg","修改失败！");
		}
		ret.put("type","success");
		ret.put("msg","修改成功");
		return ret;
	}
	
	/**
	 * 删除实习单位信息
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
			ret.put("msg", "请选择要删除的数据!");
			return ret;
		}
		String idsString = "";
		for(Long id:ids){
			idsString += id + ",";
		}
		idsString = idsString.substring(0,idsString.length()-1);
		if(unitsService.delete(idsString) <= 0){
			ret.put("type", "error");
			ret.put("msg", "删除失败!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "修改成功!");
		return ret;
	}
}
