package com.bfw.classinfo.service;

import java.util.List;

import com.bfw.po.ClassInfo;

/**
 * 班级管理的业务逻辑接口
 * @author 老牛
 * 2014年11月29日
 *
 */
public interface ClassInfoService {

	/**
	 * 添加班级信息
	 * @param info
	 * @return
	 */
	public boolean add(ClassInfo info);
	
	/**
	 * 修改班级信息
	 * @param info
	 * @return
	 */
	public boolean update(ClassInfo info);
	
	/**
	 * 根据班级编号查询班级信息
	 * @param classId
	 * @return
	 */
	public ClassInfo getClassInfo(Integer classId);
	
	/**
	 * 查询班级信息
	 * @param info 查询条件
	 * @return
	 */
	public List<ClassInfo>  getList(ClassInfo info);
}
