package com.bfw.recruitstudent.mapper;

import java.util.List;

import com.bfw.po.AuditionInfo;

public interface AuditionInfoMapper {
    int deleteByPrimaryKey(Integer auditionId);

    int insert(AuditionInfo record);

    int insertSelective(AuditionInfo record);

    AuditionInfo selectByPrimaryKey(Integer auditionId);

    int updateByPrimaryKeySelective(AuditionInfo record);

    int updateByPrimaryKey(AuditionInfo record);
     
    /**
     * 根据条件查询试听记录信息
     * @param info
     * @return
     */
    public List<AuditionInfo> getAuditionList(AuditionInfo info);
}