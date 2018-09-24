package com.bfw.po;
/**
* <p>Title: ClassroomInfo</p>  
* <p>Description: 教室信息</p>  
* @author William  
* @date 2018-7-29  
* @version 1.0
 */
public class ClassroomInfo {
    private Integer classroomId;

    private String classroomName;

    private Integer classroomMax;

    private String classroomInfo;

    private String classroomRemark;

    private String classroomMark;

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public Integer getClassroomMax() {
        return classroomMax;
    }

    public void setClassroomMax(Integer classroomMax) {
        this.classroomMax = classroomMax;
    }

    public String getClassroomInfo() {
        return classroomInfo;
    }

    public void setClassroomInfo(String classroomInfo) {
        this.classroomInfo = classroomInfo;
    }

    public String getClassroomRemark() {
        return classroomRemark;
    }

    public void setClassroomRemark(String classroomRemark) {
        this.classroomRemark = classroomRemark;
    }

    public String getClassroomMark() {
        return classroomMark;
    }

    public void setClassroomMark(String classroomMark) {
        this.classroomMark = classroomMark;
    }
}