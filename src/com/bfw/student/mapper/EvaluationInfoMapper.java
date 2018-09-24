package com.bfw.student.mapper;

import java.util.List;

import com.bfw.po.EvaluationInfo;

public interface EvaluationInfoMapper {
    int deleteByPrimaryKey(Integer evaluationId);

    int insert(EvaluationInfo record);

    int insertSelective(EvaluationInfo record);

    EvaluationInfo selectByPrimaryKey(Integer evaluationId);

    int updateByPrimaryKeySelective(EvaluationInfo record);

    int updateByPrimaryKey(EvaluationInfo record);
    
    public List<EvaluationInfo> getEvaluationInfoList(EvaluationInfo info);
}