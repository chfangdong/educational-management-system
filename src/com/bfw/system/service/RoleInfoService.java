package com.bfw.system.service;

import java.util.List;

import com.bfw.po.AuthorityInfo;
import com.bfw.po.RoleInfo;

/**
 * 角色管理的业务逻辑接口
 * @author 老牛
 * 时间：2014年11月1日
 */
public interface RoleInfoService {

	/**
	 * 添加角色信息
	 * @param role 角色信息
	 * @return
	 */
	public boolean addRole(RoleInfo role);
	
	/**
	 * 修改角色信息
	 * @param role 角色信息
	 * @return
	 */
	public boolean updateRole(RoleInfo role);
	
	/**
	 * 根据条件查询角色信息
	 * @param role
	 * @return
	 */
	public List<RoleInfo> getRoleList(RoleInfo role);
	
	/**
	 * 根据编号查询角色信息
	 * @param roleId 角色编号
	 * @return
	 */
	public RoleInfo getRoleInfo(Integer roleId);

	

}
