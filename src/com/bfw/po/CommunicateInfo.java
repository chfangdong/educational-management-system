package com.bfw.po;

import java.util.Date;

/**
* <p>Title: CommunicateInfo</p>  
* <p>Description: 沟通信息</p>  
* @author William  
* @date 2018-7-29  
* @version 1.0
 */
public class CommunicateInfo {
	private Integer communicateId;

	private Integer studentId;

	private String studentName;

	private Integer staffId;

	private String staffName;

	private Date communicateTime;

	private String communicateContent;

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getCommunicateId() {
		return communicateId;
	}

	public void setCommunicateId(Integer communicateId) {
		this.communicateId = communicateId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Date getCommunicateTime() {
		return communicateTime;
	}

	public void setCommunicateTime(Date communicateTime) {
		this.communicateTime = communicateTime;
	}

	public String getCommunicateContent() {
		return communicateContent;
	}

	public void setCommunicateContent(String communicateContent) {
		this.communicateContent = communicateContent;
	}
}