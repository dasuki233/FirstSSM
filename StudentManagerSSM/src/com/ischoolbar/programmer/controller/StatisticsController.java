package com.ischoolbar.programmer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ischoolbar.programmer.entity.Independent;
import com.ischoolbar.programmer.entity.Statistics;
import com.ischoolbar.programmer.entity.Student;
import com.ischoolbar.programmer.page.Page;
import com.ischoolbar.programmer.service.IndependentService;
import com.ischoolbar.programmer.service.StatisticsService;

import net.sf.json.JSONArray;
/**
 *统计与分析
 * @author zjj
 *
 */
@RequestMapping("/statistics")
@Controller
public class StatisticsController {
	
	private static final Object Page2 = null;
	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private IndependentService independentService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(ModelAndView model){
		model.setViewName("statistics/statistics_list");
		List<Independent> independentList = independentService.findAll();
		model.addObject("independentList",independentList );
		model.addObject("independentListJson",JSONArray.fromObject(independentList));
		return model;
	}

	
	/**
	 * 
	 * @param sdId
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/get_list",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getList(
			@RequestParam(value="sdId",required=false,defaultValue="") String sdId,
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
			queryMap.put("sdId",loginedStudent.getUsername());
		}
		queryMap.put("offset",page.getOffset());
		queryMap.put("pageSize",page.getRows());
		ret.put("rows", statisticsService.findList(queryMap));
		ret.put("total",statisticsService.getTotal(queryMap));
		return ret;
	}
}
