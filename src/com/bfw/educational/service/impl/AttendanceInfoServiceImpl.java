package com.bfw.educational.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.educational.mapper.AttendanceInfoMapper;
import com.bfw.educational.service.AttendanceInfoService;
import com.bfw.po.AttendanceInfo;

@Service
public class AttendanceInfoServiceImpl implements AttendanceInfoService {

	@Resource(name = "attendanceInfoMapper")
	private AttendanceInfoMapper attendanceInfoMapper;

	@Override
	public boolean add(AttendanceInfo info) {
		try {

			int i = attendanceInfoMapper.insertSelective(info);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(AttendanceInfo info) {
		try {

			int i = attendanceInfoMapper.updateByPrimaryKeySelective(info);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Integer attendanceId) {
		try {

			int i = attendanceInfoMapper.deleteByPrimaryKey(attendanceId);
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public AttendanceInfo getAttendanceInfo(Integer attendanceId) {
		// TODO Auto-generated method stub
		return attendanceInfoMapper.selectByPrimaryKey(attendanceId);
	}

	@Override
	public List<AttendanceInfo> getList(AttendanceInfo info) {
		// TODO Auto-generated method stub
		return attendanceInfoMapper.getAttendanceInfoList(info);
	}

}
