package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;

/**
 * ʵϰ��λ��Ϣʵ��
 * @author zjj
 *
 */
@Component
//�Զ��ŵ�������
public class Units {
	private Long id;
	private String sdId;//ѧ������
	private String name;//��λ����
	private String scale;//��λ��ģ
	private String qualification;//��λ����
	private String nature;//��λ����
	private String pattern;//У�����ģʽ
	private String job;//��λ����
	private String tcId;//ָ����ʦ����
	private String performance;//����ҵ��
	private String honor;//�����ƺ�
	private String worktime;//���¸�λ��ʱ��
	private String tel;//��ϵ��ʽ
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getTcId() {
		return tcId;
	}
	public void setTcId(String tcId) {
		this.tcId = tcId;
	}
}
