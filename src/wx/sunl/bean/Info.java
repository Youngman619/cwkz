package wx.sunl.bean;

import java.sql.Timestamp;

public class Info {
	private String infoId;
	private String infoTittle;
	private String infoContent;
	private String empId;
	private String empNo;
	private Timestamp putTime;
	private String remark;
	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getInfoTittle() {
		return infoTittle;
	}
	public void setInfoTittle(String infoTittle) {
		this.infoTittle = infoTittle;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public Timestamp getPutTime() {
		return putTime;
	}
	public void setPutTime(Timestamp putTime) {
		this.putTime = putTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
