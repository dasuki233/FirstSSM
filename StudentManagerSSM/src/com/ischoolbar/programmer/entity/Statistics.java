package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * ͳ�������ʵ��
 * @author zjj
 *
 */
@Component
public class Statistics {
	private String sdId;//��ȡ����
	private String site;//��ȡ��ַ
	private Long score;//��ȡʵϰ�ɼ�
	private String duikou;//��ȡ�Ƿ�Կ�
	private String remark;//��������
	
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
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public String getDuikou() {
		return duikou;
	}
	public void setDuikou(String duikou) {
		this.duikou = duikou;
	}
	
	
	
}
