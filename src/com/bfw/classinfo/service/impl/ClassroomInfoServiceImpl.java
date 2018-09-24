package com.bfw.classinfo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.classinfo.mapper.ClassroomInfoMapper;
import com.bfw.classinfo.service.ClassroomInfoService;
import com.bfw.po.ClassroomInfo;

@Service
public class ClassroomInfoServiceImpl implements ClassroomInfoService {

	@Resource(name="classroomInfoMapper")
	private ClassroomInfoMapper classroomInfoMapper;
	
	@Override
	public boolean addClassroom(ClassroomInfo info) {
		try {
			
			int i = classroomInfoMapper.insertSelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateClassroom(ClassroomInfo info) {
	try {
			
			int i = classroomInfoMapper.updateByPrimaryKeySelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ClassroomInfo getClassroomInfo(Integer classroomId) {
		// TODO Auto-generated method stub
		return classroomInfoMapper.selectByPrimaryKey(classroomId);
	}

	@Override
	public List<ClassroomInfo> getClassroomList(ClassroomInfo info) {
		// TODO Auto-generated method stub
		return classroomInfoMapper.getClassroomList(info);
	}

}
