package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;
/**
 * 招聘公司信息实体
 * @author zjj
 *
 */
@Component
public class Applymsg {
	private Long id;
	private String name;//公司名称
	private String job;//岗位名称
	private String site;//地址
	private String pattern;//校企合作模式
	private String salary;//薪资
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
