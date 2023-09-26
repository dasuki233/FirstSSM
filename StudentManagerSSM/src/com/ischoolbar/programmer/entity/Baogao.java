package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;
/**
 * 变更实习单位报告实体
 * @author zjj
 *
 */
@Component
public class Baogao {
	private Long id;
	private String sdId;//学生姓名
	private String former;//原单位
	private String now;//变更单位
	private String reason;//理由
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSdId() {
		return sdId;
	}
	public void setSdId(String sdId) {
		this.sdId = sdId;
	}
	public String getFormer() {
		return former;
	}
	public void setFormer(String former) {
		this.former = former;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
