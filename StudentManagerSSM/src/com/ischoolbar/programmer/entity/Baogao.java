package com.ischoolbar.programmer.entity;

import org.springframework.stereotype.Component;
/**
 * ���ʵϰ��λ����ʵ��
 * @author zjj
 *
 */
@Component
public class Baogao {
	private Long id;
	private String sdId;//ѧ������
	private String former;//ԭ��λ
	private String now;//�����λ
	private String reason;//����
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
