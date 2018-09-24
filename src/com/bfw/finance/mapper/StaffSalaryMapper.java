package com.bfw.finance.mapper;

import java.util.List;

import com.bfw.po.StaffSalary;

public interface StaffSalaryMapper {
    int deleteByPrimaryKey(Integer staffSalaryId);

    int insert(StaffSalary record);

    int insertSelective(StaffSalary record);

    StaffSalary selectByPrimaryKey(Integer staffSalaryId);

    int updateByPrimaryKeySelective(StaffSalary record);

    int updateByPrimaryKey(StaffSalary record);
    
    
    public List<StaffSalary> getStaffSalaryList(StaffSalary info);
}