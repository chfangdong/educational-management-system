package com.bfw.classinfo.service;

import java.util.List;

import com.bfw.po.SyllabusInfo;

/**
 * 课程表管理的业务逻辑接口
 * @author 老牛
 * 2014年11月29日
 *
 */
public interface SyllabusInfoService {

	/**
	 * 添加课程表信息
	 * @param info 课程表
	 * @return
	 */
	public boolean addSyllabus(SyllabusInfo info);
	
	/**
	 * 修改课程表信息
	 * @param info 课程表
	 * @return
	 */
	public boolean updateSyllabus(SyllabusInfo info);
	
	/**
	 * 根据编号查询课程表信息
	 * @param syllabusId
	 * @return
	 */
	public SyllabusInfo getSyllabusInfo(Integer syllabusId);
	
	/**
	 * 根据条件查询课程表信息
	 * @param info
	 * @return
	 */
	public List<SyllabusInfo> getList(SyllabusInfo info);
	
}
