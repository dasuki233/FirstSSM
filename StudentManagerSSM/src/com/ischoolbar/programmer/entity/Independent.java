package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;
/**
 * ����ʵϰʵ��
 * @author zjj
 *
 */
@Component
//�Զ��ŵ�������
public class Independent {
	private Long id;
	private String sdId;//ѧ������
	private String name;//��λ����
	private String job;//��λ����
	private String site;//��ַ
	private String remark;//�Ƿ�����ʵϰ
	private String duikou;//�Ƿ�רҵ�Կ�
	public String getDuikou() {
		return duikou;
	}
	public void setDuikou(String duikou) {
		this.duikou = duikou;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSdId() {
		return sdId;
	}
	public void setSdId(String sdId) {
		this.sdId = sdId;
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
	
}
