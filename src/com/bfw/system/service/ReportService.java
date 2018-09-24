package com.bfw.system.service;

import com.bfw.system.dto.ReportInfo;

/**
* <p>Title: ReportService</p>  
* <p>Description: 报名业务逻辑</p>  
* @author William  
* @date 2018-8-19  
* @version 1.0
 */
public interface ReportService {

	/**
	 * 返回包报表信息
	 * @return
	 */
	public ReportInfo getReportInfo();
	
}
