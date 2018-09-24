package com.bfw.finance.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.finance.mapper.StaffSalaryMapper;
import com.bfw.finance.service.StaffSalaryService;
import com.bfw.po.StaffSalary;

@Service
public class StaffSalaryServiceImpl implements StaffSalaryService {

	@Resource(name="staffSalaryMapper")
	private StaffSalaryMapper staffSalaryMapper;
	
	@Override
	public boolean add(StaffSalary info) {
	
		try {
			
			int i = staffSalaryMapper.insertSelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(StaffSalary info) {
	try {
			
			int i = staffSalaryMapper.updateByPrimaryKeySelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<StaffSalary> getList(StaffSalary info) {
		if(info!=null && info.getStaffName()!=null && !"".equals(info.getStaffName())){
			info.setStaffName("%"+info.getStaffName()+"%");
			
		}
		return staffSalaryMapper.getStaffSalaryList(info);
	}

}
