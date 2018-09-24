package com.bfw.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.po.AuthorityInfo;
import com.bfw.system.mapper.AuthorityInfoMapper;
import com.bfw.system.mapper.RoleAuthorityInfoMapper;
import com.bfw.system.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	/**
	 * 权限信息
	 */
	@Resource(name = "authorityInfoMapper")
	private AuthorityInfoMapper authorityInfoMapper;

	/**
	 * 角色权限信息
	 */
	@Resource(name = "roleAuthorityInfoMapper")
	private RoleAuthorityInfoMapper roleAuthorityInfoMapper;

	@Override
	public List<AuthorityInfo> getList() {
		// TODO Auto-generated method stub
		return authorityInfoMapper.getAuthorityInfoList(null);
	}

	@Override
	public AuthorityInfo getAuthorityInfo(Integer authorityId) {

		return authorityInfoMapper.selectByPrimaryKey(authorityId);
	}

	@Override
	public boolean add(AuthorityInfo auth) {

		try {
			int count = authorityInfoMapper.insertSelective(auth);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(AuthorityInfo auth) {

		try {

			int count = authorityInfoMapper.updateByPrimaryKeySelective(auth);
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public void delete(Integer authorityId) throws Exception {
		if (authorityId != null) {
			// 先删除外键关联的表信息
			roleAuthorityInfoMapper.deleteByAuthorityId(authorityId);
			authorityInfoMapper.deleteByPrimaryKey(authorityId);
		}

	}

	@Override
	public boolean isDelete(Integer authorityId) {

		try {
			if (authorityId != null) {
				AuthorityInfo auth = new AuthorityInfo();
				auth.setAuthorityId(authorityId);
					
				List list = authorityInfoMapper.getAuthorityInfoList(auth);
			
				if(list!=null&&list.size()>0){
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		return true;
	}

	@Override
	public List<AuthorityInfo> getAuthList(Integer roleId) {
		// TODO Auto-generated method stub
		return authorityInfoMapper.getAuthorityByRoleIdList(roleId);
	}

}
