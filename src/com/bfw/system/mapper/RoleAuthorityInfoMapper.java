package com.bfw.system.mapper;

import java.util.List;

import com.bfw.po.RoleAuthorityInfo;

public interface RoleAuthorityInfoMapper {
    int deleteByPrimaryKey(Integer roleAuthorityId);

    int insert(RoleAuthorityInfo record);

    int insertSelective(RoleAuthorityInfo record);

    RoleAuthorityInfo selectByPrimaryKey(Integer roleAuthorityId);

    int updateByPrimaryKeySelective(RoleAuthorityInfo record);

    int updateByPrimaryKey(RoleAuthorityInfo record);
    
    /**
     * 根据权限编号删除角色权限信息
     * @param authorityId
     * @return
     */
    int deleteByAuthorityId(Integer authorityId);
    
    /**
     * 根据角色编号删除信息
     * @param roleId
     * @return
     */
    int deleteByRoleId(Integer roleId);
    
    /**
     * 查询所有角色权限信息
     * @return
     */
    public List<RoleAuthorityInfo> getRoleAuthorityInfoList(RoleAuthorityInfo record);
}