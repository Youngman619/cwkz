package wx.sunl.model;

import java.sql.Timestamp;

public class Orders {
	private String oderId;
	private String userId;
	private String roomId;
	private Timestamp liveInDate;
	private Timestamp liveOutDate;
	private String liveDays;
	public String getOderId() {
		return oderId;
	}
	public void setOderId(String oderId) {
		this.oderId = oderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public Timestamp getLiveInDate() {
		return liveInDate;
	}
	public void setLiveInDate(Timestamp liveInDate) {
		this.liveInDate = liveInDate;
	}
	public Timestamp getLiveOutDate() {
		return liveOutDate;
	}
	public void setLiveOutDate(Timestamp liveOutDate) {
		this.liveOutDate = liveOutDate;
	}
	public String getLiveDays() {
		return liveDays;
	}
	public void setLiveDays(String liveDays) {
		this.liveDays = liveDays;
	}
	
}
