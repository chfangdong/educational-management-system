package com.bfw.recruitstudent.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.po.TrackRecordInfo;
import com.bfw.recruitstudent.mapper.TrackRecordInfoMapper;
import com.bfw.recruitstudent.service.TrackRecordInfoService;

@Service
public class TrackRecordInfoServiceImpl implements TrackRecordInfoService {

	@Resource(name="trackRecordInfoMapper")
	private TrackRecordInfoMapper trackRecordInfoMapper;
	
	@Override
	public boolean addTrackRecord(TrackRecordInfo info) {
		
		try {
			int count = trackRecordInfoMapper.insertSelective(info);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<TrackRecordInfo> getTrackRecordList(TrackRecordInfo info) {
		// TODO Auto-generated method stub
		return trackRecordInfoMapper.getTrackRecordList(info);
	}

	@Override
	public boolean updateTrackRecord(TrackRecordInfo info) {
		try {
			int count = trackRecordInfoMapper.updateByPrimaryKeySelective(info);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteTrackRecord(Integer trackRecordId) {
		try {
			int count = trackRecordInfoMapper.deleteByPrimaryKey(trackRecordId);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public TrackRecordInfo getTrackRecord(Integer trackRecordId) {
		// TODO Auto-generated method stub
		return trackRecordInfoMapper.selectByPrimaryKey(trackRecordId);
	}

}
