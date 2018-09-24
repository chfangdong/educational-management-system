package com.bfw.po;

import java.util.Date;

public class StaffSalary {
    private Integer staffSalaryId;

    private Integer staffId;
    
    //领取人姓名
    private String staffName;

    private Integer staStaffId;
    
    //财务人员
    private String  financeName;

    private Double totalSalary;

    private Double deductSalary;

    private Double realSalary;

    private String isUesd;

    private Date staffSalaryTime;

    private String staffRemark;
    
    private String url;
    
    
    

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getFinanceName() {
		return financeName;
	}

	public void setFinanceName(String financeName) {
		this.financeName = financeName;
	}

	public Integer getStaffSalaryId() {
        return staffSalaryId;
    }

    public void setStaffSalaryId(Integer staffSalaryId) {
        this.staffSalaryId = staffSalaryId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getStaStaffId() {
        return staStaffId;
    }

    public void setStaStaffId(Integer staStaffId) {
        this.staStaffId = staStaffId;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Double getDeductSalary() {
        return deductSalary;
    }

    public void setDeductSalary(Double deductSalary) {
        this.deductSalary = deductSalary;
    }

    public Double getRealSalary() {
        return realSalary;
    }

    public void setRealSalary(Double realSalary) {
        this.realSalary = realSalary;
    }

    public String getIsUesd() {
        return isUesd;
    }

    public void setIsUesd(String isUesd) {
        this.isUesd = isUesd;
    }

    public Date getStaffSalaryTime() {
        return staffSalaryTime;
    }

    public void setStaffSalaryTime(Date staffSalaryTime) {
        this.staffSalaryTime = staffSalaryTime;
    }

    public String getStaffRemark() {
        return staffRemark;
    }

    public void setStaffRemark(String staffRemark) {
        this.staffRemark = staffRemark;
    }
}