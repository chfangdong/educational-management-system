package com.bfw.recruitstudent.service;

import java.util.List;

import com.bfw.po.TrackRecordInfo;

/**
 * 跟踪记录的业务逻辑层
 * @author 老牛
 * 2014年11月25日
 *
 */
public interface TrackRecordInfoService {

	/**
	 * 添加跟踪记录信息
	 * @param info
	 * @return
	 */
	public boolean addTrackRecord(TrackRecordInfo info);
	

	/**
	 * 修改跟踪记录信息
	 * @param info
	 * @return
	 */
	public boolean updateTrackRecord(TrackRecordInfo info);
	
	/**
	 * 修删除跟踪记录信息
	 * @param trackRecordId
	 * @return
	 */
	public boolean deleteTrackRecord(Integer trackRecordId);
	
	/**
	 * 根据条件查询信息
	 * @param info
	 * @return
	 */
	public List<TrackRecordInfo> getTrackRecordList(TrackRecordInfo info);
	
	/**
	 * 根据编号查询跟踪记录信息
	 * @param trackRecordId
	 * @return
	 */
	public TrackRecordInfo getTrackRecord(Integer trackRecordId);

}
