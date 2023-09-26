package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * 实习通知实体
 * @author zjj
 *
 */
@Component
//自动放到容器里
public class Inform {
	private Long id;
	private String studentId;//获取学生姓名
	private String username;//id
	private String arrange;//实习时间安排
	private String testt;//岗前测试时间安排
	private String training;//培训时间安排
	private String sqsj;//申请岗位(单位)
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSqsj() {
		return sqsj;
	}
	public void setSqsj(String sqsj) {
		this.sqsj = sqsj;
	}
	public Long getId() {
		return id;
	}
	public String getArrange() {
		return arrange;
	}
	public String getTestt() {
		return testt;
	}
	public String getTraining() {
		return training;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setArrange(String arrange) {
		this.arrange = arrange;
	}
	public void setTestt(String testt) {
		this.testt = testt;
	}
	public void setTraining(String training) {
		this.training = training;
	}
}
