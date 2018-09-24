package com.bfw.classinfo.service;

import java.util.List;

import com.bfw.po.ClassroomInfo;

/**
 * 教室信息管理业务逻辑接口
 * @author 老牛
 * 2014年11月29日
 *
 */
public interface ClassroomInfoService {

	/**
	 * 添加教室信息
	 * @param info
	 * @return
	 */
	public boolean addClassroom(ClassroomInfo info);
	
	/**
	 * 修改教室信息
	 * @param info
	 * @return
	 */
	public boolean updateClassroom(ClassroomInfo info);
	
	/**
	 * 根据编号查询教室信息
	 * @param classroomId
	 * @return
	 */
	public ClassroomInfo getClassroomInfo(Integer classroomId);
	
	
	/**
	 * 查询教室信息
	 * @param info 查询条件
	 * @return
	 */
	public List<ClassroomInfo> getClassroomList(ClassroomInfo info);
}
