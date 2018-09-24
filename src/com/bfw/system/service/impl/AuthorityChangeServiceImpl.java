package com.bfw.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bfw.po.RoleAuthorityInfo;
import com.bfw.system.mapper.RoleAuthorityInfoMapper;
import com.bfw.system.service.AuthorityChangeService;

@Service
public class AuthorityChangeServiceImpl implements AuthorityChangeService {

	@Resource(name = "roleAuthorityInfoMapper")
	private RoleAuthorityInfoMapper roleAuthorityInfoMapper;

	@Override
	public void add(Integer roleId, Integer[] anthortyIds) throws Exception {

		roleAuthorityInfoMapper.deleteByRoleId(roleId);
		
		for (Integer anthortyId : anthortyIds) {
			RoleAuthorityInfo rai = new RoleAuthorityInfo();
			rai.setRoleId(roleId);
			rai.setAuthorityId(anthortyId);

			roleAuthorityInfoMapper.insertSelective(rai);
		}

	}

	@Override
	public List<RoleAuthorityInfo> getRoleAuthorityList(
			RoleAuthorityInfo roleAuthorityInfo) {
		
		return roleAuthorityInfoMapper.getRoleAuthorityInfoList(roleAuthorityInfo);
	}

}
