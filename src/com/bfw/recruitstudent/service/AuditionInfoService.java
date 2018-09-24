package com.bfw.recruitstudent.service;

import java.util.List;

import com.bfw.po.AuditionInfo;

/**
 * 试听记录的业务逻辑接口
 * @author 老牛
 * 2014年11月25日
 *
 */
public interface AuditionInfoService {
	
	/**
	 * 根据条件查询试听记录信息
	 * @param info
	 * @return
	 */
	public List<AuditionInfo> getList(AuditionInfo info);

	/**
	 * 添加试听记录
	 * @param info
	 * @return
	 */
	public boolean addAudition(AuditionInfo info);
	
	/**
	 * 修改试听记录
	 * @param info
	 * @return
	 */
	public boolean updateAudition(AuditionInfo info);
	
	/**
	 * 根据编号删除试听记录信息
	 * @param auditionId
	 * @return
	 */
	public boolean deleteAudition(Integer auditionId);
	
	/**
	 * 根据编号查询信息
	 * @param auditionId
	 * @return
	 */
	public AuditionInfo getAuditionInfo(Integer auditionId);
	
	
}
