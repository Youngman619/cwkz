package wx.sunl.bean;

import java.sql.Timestamp;

public class Advice {
	private String adviceId;
	private String imgUrl01;
	private String imgUrl02;
	private String imgUrl03;
	private String imgUrl04;
	private String adviceContent;
	private String userId;
	private String userName;
	private Timestamp createTime;
	private Timestamp returnTime;
	public String getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(String adviceId) {
		this.adviceId = adviceId;
	}
	public String getImgUrl01() {
		return imgUrl01;
	}
	public void setImgUrl01(String imgUrl01) {
		this.imgUrl01 = imgUrl01;
	}
	public String getImgUrl02() {
		return imgUrl02;
	}
	public void setImgUrl02(String imgUrl02) {
		this.imgUrl02 = imgUrl02;
	}
	public String getImgUrl03() {
		return imgUrl03;
	}
	public void setImgUrl03(String imgUrl03) {
		this.imgUrl03 = imgUrl03;
	}
	public String getImgUrl04() {
		return imgUrl04;
	}
	public void setImgUrl04(String imgUrl04) {
		this.imgUrl04 = imgUrl04;
	}
	public String getAdviceContent() {
		return adviceContent;
	}
	public void setAdviceContent(String adviceContent) {
		this.adviceContent = adviceContent;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Timestamp returnTime) {
		this.returnTime = returnTime;
	}
	
}
