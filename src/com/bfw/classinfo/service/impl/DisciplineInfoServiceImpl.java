package com.bfw.classinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.classinfo.mapper.DisciplineInfoMapper;
import com.bfw.classinfo.service.DisciplineInfoService;
import com.bfw.po.DisciplineInfo;

@Service
public class DisciplineInfoServiceImpl implements DisciplineInfoService {

	@Resource(name="disciplineInfoMapper")
	private DisciplineInfoMapper disciplineInfoMapper;
	
	@Override
	public boolean addDisciplineInfo(DisciplineInfo info) {
		
		try {
			int i = disciplineInfoMapper.insertSelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<DisciplineInfo> getList(DisciplineInfo info) {
		// TODO Auto-generated method stub
		return disciplineInfoMapper.getDisciplineList(info);
	}

	@Override
	public DisciplineInfo getDisciplineInfo(Integer disciplineId) {
		// TODO Auto-generated method stub
		return disciplineInfoMapper.selectByPrimaryKey(disciplineId);
	}

	@Override
	public boolean updateDisciplineInfo(DisciplineInfo info) {
		
		try {
			int i = disciplineInfoMapper.updateByPrimaryKeySelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}



}
