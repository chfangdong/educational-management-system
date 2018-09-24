package com.bfw.system.service;

import java.util.List;

import com.bfw.po.DataDictionary;

/**
 * 数据字典业务逻辑
 * @author 老牛
 * 2014年11月19日
 *
 */
public interface DataDictionaryService {

	/**
	 * 根据条件查询数据字典信息
	 * @param data 查询条件
	 * @return
	 */
	public List<DataDictionary> getDataList(DataDictionary data);
	
	/**
	 * 添加数据字典信息
	 * @param data
	 * @return
	 */
	public boolean addData(DataDictionary data);
	
	/**
	 * 根据编号查询信息
	 * @param dataId 编号
	 * @return
	 */
	public DataDictionary getDataDictionary(Integer dataId);
	
	/**
	 * 修改信息
	 * @param data
	 * @return
	 */
	public boolean updateData(DataDictionary data);
	
	/**
	 * 根据编号删除数据字典信息
	 * @param dataId
	 * @return
	 */
	public boolean deleteData(Integer dataId);
}
