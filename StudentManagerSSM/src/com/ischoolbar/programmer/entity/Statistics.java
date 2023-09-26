package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * 统计与分析实体
 * @author zjj
 *
 */
@Component
public class Statistics {
	private String sdId;//获取姓名
	private String site;//获取地址
	private Long score;//获取实习成绩
	private String duikou;//获取是否对口
	private String remark;//申请类型
	
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
