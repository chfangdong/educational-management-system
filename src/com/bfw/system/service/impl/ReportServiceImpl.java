package com.bfw.system.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.system.dto.ReportInfo;
import com.bfw.system.mapper.ReportMapper;
import com.bfw.system.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Resource(name="reportMapper")
	private ReportMapper reportMapper;
	
	@Override
	public ReportInfo getReportInfo() {
		ReportInfo info = new ReportInfo();
		
		//学员意向状态的报表
		info.setStudentSateList(reportMapper.getStudentSateList());
		
		//学员类型状态的报表
		info.setStudentMarkList(reportMapper.getStudentMarkList());
		
		info.setStudentSchoolList(reportMapper.getStudentSchoolList());
		
		info.setStudentList(reportMapper.getStudentList());
		
		return info;
	}

}
