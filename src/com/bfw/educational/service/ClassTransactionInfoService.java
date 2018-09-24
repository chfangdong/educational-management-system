package com.bfw.educational.service;

import java.util.List;

import com.bfw.po.ClassTransactionInfo;

/**
 * 班级事务管理的业务逻辑接口
 * @author 老牛
 * 2014年12月1日
 *
 */
public interface ClassTransactionInfoService {

	/**
	 * 添加班级事务信息
	 * @param info
	 * @return
	 */
	public boolean add(ClassTransactionInfo info);
	

	/**
	 * 修改班级事务信息
	 * @param info
	 * @return
	 */
	public boolean update(ClassTransactionInfo info);
	

	/**
	 * 根据编号删除班级事务信息
	 * @param info
	 * @return
	 */
	public boolean delete(Integer classTransactionId);
	
	/**
	 * 根据编号查询班级事务信息
	 * @param classTransactionId 编号
	 * @return
	 */
	public ClassTransactionInfo getInfo(Integer classTransactionId);
	
	/**
	 * 根据条件查询班级事务信息
	 * @param info 班级事务
	 * @return
	 */
	public List<ClassTransactionInfo> getList(ClassTransactionInfo info);
}
