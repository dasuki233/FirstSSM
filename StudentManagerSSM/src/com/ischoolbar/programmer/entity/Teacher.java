package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * ��ʦʵ��
 * @author zjj
 *
 */
@Component
public class Teacher {
	private Long id;//����������
	private String username;//�û���
	private String password;//����
	private String performance;//����ҵ��
	private String honor;//�����ƺ�
	private String worktime;//����ʱ��
	private String tel;//�绰
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
