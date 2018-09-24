package com.bfw.po;

import java.util.Date;
/**
* <p>Title: EvaluationInfo</p>  
* <p>Description: 学员评价</p>  
* @author William  
* @date 2018-7-30  
* @version 1.0
 */
public class EvaluationInfo {
    private Integer evaluationId;

    private Integer studentId;
    
    private String studentName;

    private String evaluationTitle;

    private String evaluationContent;

    private String evaluationCourse;

    private String evaluationTeacher;

    private Date evaluationTime;

    
    public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getEvaluationTitle() {
        return evaluationTitle;
    }

    public void setEvaluationTitle(String evaluationTitle) {
        this.evaluationTitle = evaluationTitle;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public String getEvaluationCourse() {
        return evaluationCourse;
    }

    public void setEvaluationCourse(String evaluationCourse) {
        this.evaluationCourse = evaluationCourse;
    }

    public String getEvaluationTeacher() {
        return evaluationTeacher;
    }

    public void setEvaluationTeacher(String evaluationTeacher) {
        this.evaluationTeacher = evaluationTeacher;
    }

    public Date getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(Date evaluationTime) {
        this.evaluationTime = evaluationTime;
    }
}