package com.ischoolbar.programmer.controller;

import java.util.HashMap;
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
import com.ischoolbar.programmer.page.Page;
import com.ischoolbar.programmer.service.TeacherService;

/**
 * 教师控制器
 * @author zjj
 *
 */
@RequestMapping("/teacher")
@Controller
public class TeacherController {
	
	@Autowired
	public TeacherService teacherService;
	/**
	 * 教师管理列表页
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("teacher/teacher_list");
		return model;
	}
	
	/**
	 * 获取教师列别
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/get_list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(
			@RequestParam(value="username",required=false,defaultValue="")String username,
			HttpServletRequest request,
			Page page
			){
		Map<String, Object> ret = new HashMap<String, Object>();
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("username","%"+username+"%");
		Object attribute = request.getSession().getAttribute("userType");
		if("3".equals(attribute.toString())){
			//说明是教师
			Teacher loginedTeacher = (Teacher)request.getSession().getAttribute("user");
			queryMap.put("username",loginedTeacher.getUsername());
		}
		queryMap.put("offset",page.getOffset());
		queryMap.put("pageSize",page.getRows());
		ret.put("rows", teacherService.findList(queryMap));
		ret.put("total",teacherService.getTotal(queryMap));
		return ret;
	}
	
	/**
	 * 删除用户操作
	 * @param user
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
		if(teacherService.delete(idsString) <= 0){
			ret.put("type", "error");
			ret.put("msg", "删除失败!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "修改成功!");
		return ret;
	}
	
	/**
	 * 编辑用户操作
	 * @param teacher
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> edit(Teacher teacher){
			Map<String, String> ret = new HashMap<String, String>();
			if(teacher == null){
				ret.put("type", "error");
				ret.put("msg", "数据绑定出错，请联系开发作者!");
				return ret;
			}
			if(StringUtils.isEmpty(teacher.getUsername())){
				ret.put("type", "error");
				ret.put("msg", "用户名不能为空!");
				return ret;
			}
			if(StringUtils.isEmpty(teacher.getPassword())){
				ret.put("type", "error");
				ret.put("msg", "密码不能为空!");
				return ret;
			}
			if(isExist(teacher.getUsername(), null)){
					ret.put("type", "error");
					ret.put("msg", "该用户名已经存在!");
					return ret;
				}
			if(teacherService.edit(teacher) <= 0){
				ret.put("type", "error");
				ret.put("msg", "修改失败!");
				return ret;
			}
			ret.put("type", "success");
			ret.put("msg", "修改成功!");
			return ret;
		}
	
	/**
	 * 添加用户操作
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> add(Teacher teacher){
		Map<String, String> ret = new HashMap<String, String>();
		if(teacher == null){
			ret.put("type", "error");
			ret.put("msg", "数据绑定出错，请联系开发作者!");
			return ret;
		}
		if(StringUtils.isEmpty(teacher.getUsername())){
			ret.put("type", "error");
			ret.put("msg", "用户名不能为空!");
			return ret;
		}
		if(StringUtils.isEmpty(teacher.getPassword())){
			ret.put("type", "error");
			ret.put("msg", "密码不能为空!");
			return ret;
		}
		Teacher existUser = teacherService.findByTeacherName(teacher.getUsername());
		if(existUser != null){
			ret.put("type", "error");
			ret.put("msg", "该用户名已经存在!");
			return ret;
		}
		if(teacherService.add(teacher) <= 0){
			ret.put("type", "error");
			ret.put("msg", "添加失败!");
			return ret;
		}
		ret.put("type", "success");
		ret.put("msg", "添加成功!");
		return ret;
	}
	private boolean isExist(String username,Long id){
		Teacher teacher = teacherService.findByTeacherName(username);
		if(teacher != null){
			if(id == null){
				return true;
			}
			if(teacher.getId().longValue() != id.longValue()){
				return true;
			}
		}
		return false;
	}
}
