package com.bfw.recruitstudent.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.po.AuditionInfo;
import com.bfw.recruitstudent.mapper.AuditionInfoMapper;
import com.bfw.recruitstudent.service.AuditionInfoService;

@Service
public class AuditionInfoServiceImpl implements AuditionInfoService {

	@Resource(name = "auditionInfoMapper")
	private AuditionInfoMapper auditionInfoMapper;

	@Override
	public boolean addAudition(AuditionInfo info) {
		try {

			int count = auditionInfoMapper.insertSelective(info);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<AuditionInfo> getList(AuditionInfo info) {
		// TODO Auto-generated method stub
		return auditionInfoMapper.getAuditionList(info);
	}

	@Override
	public boolean updateAudition(AuditionInfo info) {
		try {

			int count = auditionInfoMapper.updateByPrimaryKeySelective(info);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAudition(Integer auditionId) {
		try {

			int count = auditionInfoMapper.deleteByPrimaryKey(auditionId);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public AuditionInfo getAuditionInfo(Integer auditionId) {
		// TODO Auto-generated method stub
		return auditionInfoMapper.selectByPrimaryKey(auditionId);
	}

}
