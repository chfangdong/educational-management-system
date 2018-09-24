package com.bfw.educational.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.educational.mapper.ClassTransactionInfoMapper;
import com.bfw.educational.service.ClassTransactionInfoService;
import com.bfw.po.ClassTransactionInfo;


@Service
public class ClassTransactionInfoServiceImpl implements
		ClassTransactionInfoService {

	@Resource(name="classTransactionInfoMapper")
	private ClassTransactionInfoMapper classTransactionInfoMapper;
	
	@Override
	public boolean add(ClassTransactionInfo info) {
		try {
			int i = classTransactionInfoMapper.insertSelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(ClassTransactionInfo info) {
		try {
			int i = classTransactionInfoMapper.updateByPrimaryKeySelective(info);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Integer classTransactionId) {
		try {
			int i = classTransactionInfoMapper.deleteByPrimaryKey(classTransactionId);
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ClassTransactionInfo getInfo(Integer classTransactionId) {
		// TODO Auto-generated method stub
		return classTransactionInfoMapper.selectByPrimaryKey(classTransactionId);
	}

	@Override
	public List<ClassTransactionInfo> getList(ClassTransactionInfo info) {
		// TODO Auto-generated method stub
		return classTransactionInfoMapper.getTransactionList(info);
	}

}
