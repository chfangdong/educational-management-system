package com.bfw.po;
/**
* <p>Title: DataDictionary</p>  
* <p>Description: 数据字典</p>  
* @author William  
* @date 2018-7-30  
* @version 1.0
 */
public class DataDictionary {
    private Integer dataId;

    private String dataContent;

    private String dataType;

    private String dataDesc;

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public String getDataContent() {
        return dataContent;
    }

    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

	@Override
	public String toString() {
		return "DataDictionary [dataId=" + dataId + ", dataContent="
				+ dataContent + ", dataType=" + dataType + ", dataDesc="
				+ dataDesc + "]";
	}
    
    
}