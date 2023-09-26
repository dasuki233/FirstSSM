package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * 教师实体
 * @author zjj
 *
 */
@Component
public class Teacher {
	private Long id;//主键，自增
	private String username;//用户名
	private String password;//密码
	private String performance;//工作业绩
	private String honor;//荣誉称号
	private String worktime;//工作时间
	private String tel;//电话
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
