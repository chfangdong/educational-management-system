package com.bfw.marketing.mapper;

import java.util.List;

import com.bfw.po.EmailInfo;

public interface EmailInfoMapper {
    int deleteByPrimaryKey(Integer emailId);

    int insert(EmailInfo record);

    int insertSelective(EmailInfo record);

    EmailInfo selectByPrimaryKey(Integer emailId);

    int updateByPrimaryKeySelective(EmailInfo record);

    int updateByPrimaryKey(EmailInfo record);
    
    /**
     * 
     * @param record
     * @return
     */
    public List<EmailInfo> getEmailList(EmailInfo record);
}