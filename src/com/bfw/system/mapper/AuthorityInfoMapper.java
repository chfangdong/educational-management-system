package com.bfw.system.mapper;

import java.util.List;
import com.bfw.po.AuthorityInfo;

public interface AuthorityInfoMapper {
    int deleteByPrimaryKey(Integer authorityId);

    int insert(AuthorityInfo record);

    int insertSelective(AuthorityInfo record);

    AuthorityInfo selectByPrimaryKey(Integer authorityId);

    int updateByPrimaryKeySelective(AuthorityInfo record);

    int updateByPrimaryKey(AuthorityInfo record);
    public List<AuthorityInfo> getAuthorityInfoList(AuthorityInfo record);
    
    public List<AuthorityInfo> getAuthorityByRoleIdList(Integer roleId);
}