package com.bfw.classinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.classinfo.mapper.SyllabusInfoMapper;
import com.bfw.classinfo.service.SyllabusInfoService;
import com.bfw.po.SyllabusInfo;

@Service
public class SyllabusInfoServiceImpl implements SyllabusInfoService{

	/**
	 * 课程表的mapper
	 */
	@Resource(name="syllabusInfoMapper")
	private SyllabusInfoMapper syllabusInfoMapper;
	
	@Override
	public boolean addSyllabus(SyllabusInfo info) {
		try {
			
			int i = syllabusInfoMapper.insertSelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateSyllabus(SyllabusInfo info) {
		try {
			
			int i = syllabusInfoMapper.updateByPrimaryKeySelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public SyllabusInfo getSyllabusInfo(Integer syllabusId) {
		// TODO Auto-generated method stub
		return syllabusInfoMapper.selectByPrimaryKey(syllabusId);
	}

	@Override
	public List<SyllabusInfo> getList(SyllabusInfo info) {
		// TODO Auto-generated method stub
		return syllabusInfoMapper.getSyllabusList(info);
	}

}
