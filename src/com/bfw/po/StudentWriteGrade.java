package com.bfw.po;

import java.util.Date;

public class StudentWriteGrade {
	private Integer writeGradeId;

	private Integer studentId;

	private Integer staffId;

	private String studentName;

	private String staffName;

	private String writeGradeSubject;

	private String writeGrade;

	private Date writeGradeTime;

	private String writeGradeNote;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Integer getWriteGradeId() {
		return writeGradeId;
	}

	public void setWriteGradeId(Integer writeGradeId) {
		this.writeGradeId = writeGradeId;
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

	public String getWriteGradeSubject() {
		return writeGradeSubject;
	}

	public void setWriteGradeSubject(String writeGradeSubject) {
		this.writeGradeSubject = writeGradeSubject;
	}

	public String getWriteGrade() {
		return writeGrade;
	}

	public void setWriteGrade(String writeGrade) {
		this.writeGrade = writeGrade;
	}

	public Date getWriteGradeTime() {
		return writeGradeTime;
	}

	public void setWriteGradeTime(Date writeGradeTime) {
		this.writeGradeTime = writeGradeTime;
	}

	public String getWriteGradeNote() {
		return writeGradeNote;
	}

	public void setWriteGradeNote(String writeGradeNote) {
		this.writeGradeNote = writeGradeNote;
	}
}