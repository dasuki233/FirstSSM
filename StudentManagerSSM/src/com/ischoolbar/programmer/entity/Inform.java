package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * ʵϰ֪ͨʵ��
 * @author zjj
 *
 */
@Component
//�Զ��ŵ�������
public class Inform {
	private Long id;
	private String studentId;//��ȡѧ������
	private String username;//id
	private String arrange;//ʵϰʱ�䰲��
	private String testt;//��ǰ����ʱ�䰲��
	private String training;//��ѵʱ�䰲��
	private String sqsj;//�����λ(��λ)
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
