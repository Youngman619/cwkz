package wx.sunl.model;

import java.sql.Timestamp;

public class Employee {
	private String empId;
	private String empNo;
	private String empName;
	private String empDepNo;
	private String empJobNo;
	private Timestamp inDate;
	private String empIDCard;
	private String empPhoneNumber1;
	private String empPhoneNumber2;
	private String empAddr;
	private String remark;
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
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDepNo() {
		return empDepNo;
	}
	public void setEmpDepNo(String empDepNo) {
		this.empDepNo = empDepNo;
	}
	public String getEmpJobNo() {
		return empJobNo;
	}
	public void setEmpJobNo(String empJobNo) {
		this.empJobNo = empJobNo;
	}
	public Timestamp getInDate() {
		return inDate;
	}
	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}
	public String getEmpIDCard() {
		return empIDCard;
	}
	public void setEmpIDCard(String empIDCard) {
		this.empIDCard = empIDCard;
	}
	public String getEmpPhoneNumber1() {
		return empPhoneNumber1;
	}
	public void setEmpPhoneNumber1(String empPhoneNumber1) {
		this.empPhoneNumber1 = empPhoneNumber1;
	}
	public String getEmpPhoneNumber2() {
		return empPhoneNumber2;
	}
	public void setEmpPhoneNumber2(String empPhoneNumber2) {
		this.empPhoneNumber2 = empPhoneNumber2;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
