package com.bfw.po;

import java.util.Date;
/**
* <p>Title: AuditionInfo</p>  
* <p>Description: 学生试听信息</p>  
* @author William  
* @date 2018-7-29  
* @version 1.0
 */
public class AuditionInfo {
    private Integer auditionId;

    private Integer studentId;

    private Date auditionTime;

    private String auditionAddr;

    private String auditionCourse;

    private String auditionDesc;
    
    private String studentName;
    
    

    public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getAuditionId() {
        return auditionId;
    }

    public void setAuditionId(Integer auditionId) {
        this.auditionId = auditionId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Date getAuditionTime() {
        return auditionTime;
    }

    public void setAuditionTime(Date auditionTime) {
        this.auditionTime = auditionTime;
    }

    public String getAuditionAddr() {
        return auditionAddr;
    }

    public void setAuditionAddr(String auditionAddr) {
        this.auditionAddr = auditionAddr;
    }

    public String getAuditionCourse() {
        return auditionCourse;
    }

    public void setAuditionCourse(String auditionCourse) {
        this.auditionCourse = auditionCourse;
    }

    public String getAuditionDesc() {
        return auditionDesc;
    }

    public void setAuditionDesc(String auditionDesc) {
        this.auditionDesc = auditionDesc;
    }
}