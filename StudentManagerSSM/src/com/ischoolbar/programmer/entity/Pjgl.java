package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * ���۹���ʵ��
 * @author zjj
 *
 */
@Component
public class Pjgl {
	private Long id;
	private String sdId;//��ȡѧ������
	private String summary;//����ʵϰ����
	private String scsxbg;//�ϴ�ʵϰ����
	private Long score;//ʵϰ�ɼ�
	private String pj;//��ʦ��������
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
