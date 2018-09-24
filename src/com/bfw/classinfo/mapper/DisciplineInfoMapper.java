package com.bfw.classinfo.mapper;

import java.util.List;

import com.bfw.po.DisciplineInfo;

public interface DisciplineInfoMapper {
    int deleteByPrimaryKey(Integer disciplineId);

    int insert(DisciplineInfo record);

    int insertSelective(DisciplineInfo record);

    DisciplineInfo selectByPrimaryKey(Integer disciplineId);

    int updateByPrimaryKeySelective(DisciplineInfo record);

    int updateByPrimaryKey(DisciplineInfo record);
    
    /**
     * 根据条件查询学科信息
     * @param record
     * @return
     */
    public List<DisciplineInfo> getDisciplineList(DisciplineInfo record);
}