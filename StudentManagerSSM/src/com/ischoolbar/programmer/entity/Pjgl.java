package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * 评价管理实体
 * @author zjj
 *
 */
@Component
public class Pjgl {
	private Long id;
	private String sdId;//获取学生姓名
	private String summary;//顶岗实习报告
	private String scsxbg;//上传实习报告
	private Long score;//实习成绩
	private String pj;//教师给予评价
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getScsxbg() {
		return scsxbg;
	}
	public void setScsxbg(String scsxbg) {
		this.scsxbg = scsxbg;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public String getPj() {
		return pj;
	}
	public void setPj(String pj) {
		this.pj = pj;
	}
}
