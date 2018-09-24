package com.bfw.classinfo.service;

import java.util.List;

import com.bfw.po.DisciplineInfo;

/**
 * 学科信息业务逻辑接口
 * @author 老牛
 * 2014年11月29日
 *
 */
public interface DisciplineInfoService {

	/**
	 * 添加学科信息
	 * @param info
	 * @return
	 */
	public boolean addDisciplineInfo(DisciplineInfo info);
	
	/**
	 * 根据提条件查询学科信息
	 * @param info 查询条件
	 * @return
	 */
	public List<DisciplineInfo> getList(DisciplineInfo info);
	
	
	/**
	 * 根据编号查询学科信息
	 * @param disciplineId
	 * @return
	 */
	public DisciplineInfo getDisciplineInfo(Integer disciplineId);

	/**
	 * 修改学科信息
	 * @param info
	 * @return
	 */
	public boolean updateDisciplineInfo(DisciplineInfo info);

	

}
