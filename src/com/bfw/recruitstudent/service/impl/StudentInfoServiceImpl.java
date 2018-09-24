package com.bfw.recruitstudent.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.po.StudentInfo;
import com.bfw.recruitstudent.mapper.StudentInfoMapper;
import com.bfw.recruitstudent.service.StudentInfoService;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

	/**
	 * 
	 */
	@Resource(name = "studentInfoMapper")
	private StudentInfoMapper studentInfoMapper;

	@Override
	public List<StudentInfo> getStudentInfoList(StudentInfo info) {

		if (info != null && info.getStudentName() != null
				&& !info.getStudentName().equals("")) {
			info.setStudentName("%"+info.getStudentName()+"%");
		}

		return studentInfoMapper.getStudentList(info);
	}

	@Override
	public boolean addStudent(StudentInfo info) {
		
		try {
			int count = studentInfoMapper.insert(info);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean updateStudent(StudentInfo info) {
		
		try {
			int count = studentInfoMapper.updateByPrimaryKeySelective(info);
			if(count>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public StudentInfo getStudentInfo(Integer studentId) {
		// TODO Auto-generated method stub
		return studentInfoMapper.selectByPrimaryKey(studentId);
	}

}
