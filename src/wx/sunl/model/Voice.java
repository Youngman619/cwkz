package wx.sunl.model;

public class Voice {
	//语音文件的id标识
	private String MediaId;
	//语音文件的格式
	private String Format;
	//消息的id标识
	private String MsgID;
	
	public Voice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getMsgID() {
		return MsgID;
	}
	public void setMsgID(String msgID) {
		MsgID = msgID;
	}
	
	
}
