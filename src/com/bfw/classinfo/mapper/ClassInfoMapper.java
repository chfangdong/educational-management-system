package com.bfw.classinfo.mapper;

import java.util.List;

import com.bfw.po.ClassInfo;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
    
    public List<ClassInfo> getClassInfoList(ClassInfo info);
}