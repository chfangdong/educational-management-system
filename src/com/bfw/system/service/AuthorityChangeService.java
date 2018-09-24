package com.bfw.system.service;

import java.util.List;

import com.bfw.po.RoleAuthorityInfo;

/**
* <p>Title: AuthorityChangeService</p>  
* <p>Description: 权限变更的业务逻辑接口</p>  
* @author William  
* @date 2018-9-22  
* @version 1.0
 */
public interface AuthorityChangeService {

	/**
	 * 添加角色权限信息
	 * @param roleId
	 * @param authorityId
	 * @throws Exception
	 */
	public void add(Integer roleId,Integer[] authorityId)throws Exception;
	
	/**
	 * 查询角色权限信息
	 * @param roleAuthorityInfo
	 * @return
	 */
	public List<RoleAuthorityInfo>  getRoleAuthorityList(RoleAuthorityInfo roleAuthorityInfo);
}
