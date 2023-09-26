package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * 实习过程实体
 * @author zjj
 *
 */
@Component
public class Processs {
	private Long id;
	private String czjl;//成长记录
	private String fbqk;//分布情况
	private String bgjh;//变更实习计划
	private String remark;//上传实习内容
	private String sdId;//获取学生
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
