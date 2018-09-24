package com.bfw.system.mapper;

import java.util.List;
import java.util.Map;

/**
* <p>Title: ReportMapper</p>  
* <p>Description: 报名的mapper</p>  
* @author William  
* @date 2018-9-16  
* @version 1.0
 */
public interface ReportMapper {

	/**
	 * 学员意向状态的报表
	 * @return
	 */
	public List<Map> getStudentSateList();
	
	/**
	 * 学员状态的报表
	 * @return
	 */
	public List<Map> getStudentMarkList();
	
	/**
	 * 学员学校分布数据
	 */
	public List<Map> getStudentSchoolList();
	
	/**
	 * 获取当天需要联系的学员信息
	 * @return
	 */
	public List<Map> getStudentList();
	
}
