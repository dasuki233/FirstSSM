package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * ʵϰ����ʵ��
 * @author zjj
 *
 */
@Component
public class Processs {
	private Long id;
	private String czjl;//�ɳ���¼
	private String fbqk;//�ֲ����
	private String bgjh;//���ʵϰ�ƻ�
	private String remark;//�ϴ�ʵϰ����
	private String sdId;//��ȡѧ��
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCzjl() {
		return czjl;
	}
	public void setCzjl(String czjl) {
		this.czjl = czjl;
	}
	public String getFbqk() {
		return fbqk;
	}
	public void setFbqk(String fbqk) {
		this.fbqk = fbqk;
	}
	public String getBgjh() {
		return bgjh;
	}
	public void setBgjh(String bgjh) {
		this.bgjh = bgjh;
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
}
