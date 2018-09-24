package com.bfw.marketing.service;

import java.util.List;

import com.bfw.po.EmailInfo;

/**
 * 邮件管理的业务逻辑层
 * @author 老牛
 * 2014年11月22日
 *
 */
public interface EmailInfoService {

	/**
	 * 发送邮件
	 * @param info
	 * @return
	 */
	public boolean addEmail(EmailInfo info);
	
	/**
	 * 根据编号删除邮件
	 * @param emailId
	 * @return
	 */
	public boolean deleteEmail(Integer emailId);
	
	/**
	 * 根据编号查询邮件信息
	 * @param emailId
	 * @return
	 */
	public EmailInfo getEmailInfo(Integer emailId);

	/**
	 * 查询多个邮件信息
	 * @param info
	 * @return
	 */
	public List<EmailInfo> getEmailList(EmailInfo info);

}
