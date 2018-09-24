package com.bfw.system.service;

import java.util.List;

import com.bfw.po.AuthorityInfo;
import com.bfw.po.StaffInfo;

/**
 * 员工信息管理的业务逻辑层
 * @author 老牛
 * 时间：2014年11月1日
 */
public interface StaffInfoService {

	/**
	 * 添加员工信息
	 * @param staff 员工信息
	 * @return true为成功  false 为失败
	 */
	public boolean addStaff(StaffInfo staff);
	
	/**
	 * 修改员工信息
	 * @param staff 员工信息
	 * @return true为成功  false 为失败
	 */
	public boolean updateStaff(StaffInfo staff);
	
	/**
	 * 根据条件查询员工信息
	 * @param staff 查询条件
	 * @return
	 */
	public List<StaffInfo> getList(StaffInfo staff);
	
	/**
	 * 根据条件查询员工信息
	 * @param staff 查询条件
	 * @return
	 */
	public List<StaffInfo> getStaffList(StaffInfo staff);
	
	/**
	 * 根据编号查询员工信息
	 * @param staffId 员工编号
	 * @return
	 */
	public StaffInfo getStaffInfo(Integer staffId);

}
