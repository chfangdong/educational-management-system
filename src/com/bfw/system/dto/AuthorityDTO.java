package com.bfw.system.dto;

import java.util.List;

import com.bfw.po.AuthorityInfo;

/**
 * 
* <p>Title: AuthorityDTO</p>  
* <p>Description: 权限变更的数据传输对象</p>  
* @author William  
* @date 2018-8-26  
* @version 1.0
 */
public class AuthorityDTO {

	/**
	 * 一级菜单
	 */
	private AuthorityInfo auth;

	/**
	 * 多个子菜单
	 */
	private List<AuthorityInfo> list;

	public AuthorityInfo getAuth() {
		return auth;
	}

	public void setAuth(AuthorityInfo auth) {
		this.auth = auth;
	}

	public List<AuthorityInfo> getList() {
		return list;
	}

	public void setList(List<AuthorityInfo> list) {
		this.list = list;
	}

}
