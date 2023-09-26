package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;
/**
 * 自主实习实体
 * @author zjj
 *
 */
@Component
//自动放到容器里
public class Independent {
	private Long id;
	private String sdId;//学生姓名
	private String name;//单位名称
	private String job;//岗位名称
	private String site;//地址
	private String remark;//是否自主实习
	private String duikou;//是否专业对口
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
