package com.bfw.student.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.po.EvaluationInfo;
import com.bfw.student.mapper.EvaluationInfoMapper;
import com.bfw.student.service.EvaluationInfoService;

@Service
public class EvaluationInfoServiceImpl implements EvaluationInfoService {

	@Resource(name = "evaluationInfoMapper")
	private EvaluationInfoMapper evaluationInfoMapper;

	@Override
	public boolean add(EvaluationInfo info) {

		try {

			int i = evaluationInfoMapper.insertSelective(info);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(EvaluationInfo info) {
		try {

			int i = evaluationInfoMapper.updateByPrimaryKeySelective(info);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Integer evaluationId) {
	try {
			
			int i = evaluationInfoMapper.deleteByPrimaryKey(evaluationId);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public EvaluationInfo getEvaluationInfo(Integer evaluationId) {
		// TODO Auto-generated method stub
		return evaluationInfoMapper.selectByPrimaryKey(evaluationId);
	}

	@Override
	public List<EvaluationInfo> getList(EvaluationInfo info) {
		// TODO Auto-generated method stub
		return evaluationInfoMapper.getEvaluationInfoList(info);
	}

}
