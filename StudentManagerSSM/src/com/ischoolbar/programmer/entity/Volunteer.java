package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * 志愿实习实体
 * @author zjj
 *
 */
@Component
//自动放到容器里
public class Volunteer {
	private Long id;
	private String sdId;
	private String name;//公司名称
	private String job;//岗位名称
	private String site;//地址
	private String duikou;
	private String remark;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
