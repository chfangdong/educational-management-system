package com.bfw.po;

/**
 * 
* <p>Title: AuthorityInfo</p>  
* <p>Description: **权限信息管理</p>  
* @author William  
* @date 2018-7-29  
* @version 1.0
 */
public class AuthorityInfo {
	private Integer authorityId;

	private Integer authorityPid;

	private String authorityName;

	private String authorityDesc;

	private String authorityUrl;

	/**
	 * 父类名称
	 */
	private String pauthorityName;

	/**
	 * 标识是否选中
	 */
	private boolean checked = false;

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getPauthorityName() {
		return pauthorityName;
	}

	public void setPauthorityName(String pauthorityName) {
		this.pauthorityName = pauthorityName;
	}

	public Integer getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	public Integer getAuthorityPid() {
		return authorityPid;
	}

	public void setAuthorityPid(Integer authorityPid) {
		this.authorityPid = authorityPid;
	}

	public String getAuthorityName() {
		System.out.println("authorityId: " + authorityId);
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityDesc() {
		return authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	public String getAuthorityUrl() {
		return authorityUrl;
	}

	public void setAuthorityUrl(String authorityUrl) {
		this.authorityUrl = authorityUrl;
	}

	@Override
	public String toString() {
		return "AuthorityInfo [authorityId=" + authorityId + ", authorityPid="
				+ authorityPid + ", authorityName=" + authorityName
				+ ", authorityDesc=" + authorityDesc + ", authorityUrl="
				+ authorityUrl + "]";
	}

}