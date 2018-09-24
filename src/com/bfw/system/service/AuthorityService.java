package com.bfw.system.service;

import java.util.List;

import com.bfw.po.AuthorityInfo;

/**
 * 权限信息的业务逻辑接口
 * @author 老牛
 * 2014年11月3日
 *
 */
public interface AuthorityService {

	/**
	 * 查询所有的权限信息
	 * @return
	 */
	public List<AuthorityInfo> getList();
	
	/**
	 * 根据编号查询权限信息
	 * @param authorityId 权限编号
	 * @return
	 */
	public AuthorityInfo getAuthorityInfo(Integer authorityId);
	
	/**
	 * 添加权限信息
	 * @param auth
	 * @return
	 */
	public boolean add(AuthorityInfo auth);
	
	/**
	 * 修改权限信息
	 * @param auth 权限信息
	 * @return
	 */
	public boolean update(AuthorityInfo auth);
	
	/**
	 * 根据编号删除权限信息
	 * @param authorityId 权限编号
	 * @return
	 */
	public void delete(Integer authorityId)throws Exception;
	
	/**
	 * 判断是否有下级节点
	 * @param authorityId
	 * @return
	 */
	public boolean isDelete(Integer authorityId);
	
	/**
	 * 根据角色编号查询权限信息
	 * @param roleId
	 * @return
	 */
	public List<AuthorityInfo> getAuthList(Integer roleId);
	
}
