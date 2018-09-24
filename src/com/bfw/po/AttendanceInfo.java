package com.bfw.po;

import java.util.Date;
/**
 * 
* <p>Title: AttendanceInfo</p>  
* <p>Description: 考勤信息</p>  
* @author William  
* @date 2018-7-29  
* @version 1.0
 */
public class AttendanceInfo {
	private Integer attendanceId;

	private Integer studentId;

	private String studentName;

	private String attendanceDesc;

	private String attendanceState;

	private Date attendanceTime;

	//考勤评论
	private String attendanceRemark;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getAttendanceDesc() {
		return attendanceDesc;
	}

	public void setAttendanceDesc(String attendanceDesc) {
		this.attendanceDesc = attendanceDesc;
	}

	public String getAttendanceState() {
		return attendanceState;
	}

	public void setAttendanceState(String attendanceState) {
		this.attendanceState = attendanceState;
	}

	public Date getAttendanceTime() {
		return attendanceTime;
	}

	public void setAttendanceTime(Date attendanceTime) {
		this.attendanceTime = attendanceTime;
	}

	public String getAttendanceRemark() {
		return attendanceRemark;
	}

	public void setAttendanceRemark(String attendanceRemark) {
		this.attendanceRemark = attendanceRemark;
	}
}