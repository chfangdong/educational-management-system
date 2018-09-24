package com.bfw.po;

import java.util.Date;
/**
* <p>Title: ClassTransactionInfo</p>  
* <p>Description: 班级事务</p>  
* @author William  
* @date 2018-7-29  
* @version 1.0
 */
public class ClassTransactionInfo {
	private Integer classTransactionId;

	private Integer classId;

	private String className;

	private String classTransactionTitle;

	private String classTransactionContent;

	private String classTransactionPerson;

	private Date classTransactionTime;

	private String classTransactionRemark;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getClassTransactionId() {
		return classTransactionId;
	}

	public void setClassTransactionId(Integer classTransactionId) {
		this.classTransactionId = classTransactionId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getClassTransactionTitle() {
		return classTransactionTitle;
	}

	public void setClassTransactionTitle(String classTransactionTitle) {
		this.classTransactionTitle = classTransactionTitle;
	}

	public String getClassTransactionContent() {
		return classTransactionContent;
	}

	public void setClassTransactionContent(String classTransactionContent) {
		this.classTransactionContent = classTransactionContent;
	}

	public String getClassTransactionPerson() {
		return classTransactionPerson;
	}

	public void setClassTransactionPerson(String classTransactionPerson) {
		this.classTransactionPerson = classTransactionPerson;
	}

	public Date getClassTransactionTime() {
		return classTransactionTime;
	}

	public void setClassTransactionTime(Date classTransactionTime) {
		this.classTransactionTime = classTransactionTime;
	}

	public String getClassTransactionRemark() {
		return classTransactionRemark;
	}

	public void setClassTransactionRemark(String classTransactionRemark) {
		this.classTransactionRemark = classTransactionRemark;
	}
}