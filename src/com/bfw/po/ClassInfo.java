package com.bfw.po;

import java.util.Date;

/**
* <p>Title: ClassInfo</p>  
* <p>Description: 班级信息</p>  
* @author William  
* @date 2018-7-29  
* @version 1.0
 */
public class ClassInfo {
    private Integer classId;

    private Integer disciplineId;

    private Integer syllabusId;

    private Integer classroomId;

    private Integer staffId;

    private String className;

    private Integer classNumber;

    private Date classStartTime;

    private Date classEndTime;

    private String classIsuesd;

    private String classState;

    private String classDesc;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }

    public Integer getSyllabusId() {
        return syllabusId;
    }

    public void setSyllabusId(Integer syllabusId) {
        this.syllabusId = syllabusId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Date getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(Date classStartTime) {
        this.classStartTime = classStartTime;
    }

    public Date getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(Date classEndTime) {
        this.classEndTime = classEndTime;
    }

    public String getClassIsuesd() {
        return classIsuesd;
    }

    public void setClassIsuesd(String classIsuesd) {
        this.classIsuesd = classIsuesd;
    }

    public String getClassState() {
        return classState;
    }

    public void setClassState(String classState) {
        this.classState = classState;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }
}