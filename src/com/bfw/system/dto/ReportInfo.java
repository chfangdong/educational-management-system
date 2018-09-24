package com.bfw.system.dto;

import java.util.List;
import java.util.Map;

/**
 * 工作台报表信息
 * 
 * @author 老牛 2014年12月4日
 *
 */
public class ReportInfo {

	/**
	 * 学员意向状态的报表
	 */
	private List<Map> studentSateList;

	/**
	 * 学员状态的报表
	 */
	private List<Map> studentMarkList;

	/**
	 * 学员学校分布数据
	 */
	private List<Map> studentSchoolList;

	/**
	 * 获取当天需要联系的学员信息
	 */
	private List<Map> studentList;

	public List<Map> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Map> studentList) {
		this.studentList = studentList;
	}

	public List<Map> getStudentSchoolList() {
		return studentSchoolList;
	}

	public void setStudentSchoolList(List<Map> studentSchoolList) {
		this.studentSchoolList = studentSchoolList;
	}

	public List<Map> getStudentMarkList() {
		return studentMarkList;
	}

	public void setStudentMarkList(List<Map> studentMarkList) {
		this.studentMarkList = studentMarkList;
	}

	public List<Map> getStudentSateList() {
		return studentSateList;
	}

	public void setStudentSateList(List<Map> studentSateList) {
		this.studentSateList = studentSateList;
	}

}
