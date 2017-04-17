package wx.sunl.model;

public class Image {
	//图片文件id标识
	private String MediaId;
	//图片文件链接Url
	private String picUrl;
	//消息id标识
	private String MsgIdl;
	
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getMsgIdl() {
		return MsgIdl;
	}
	public void setMsgIdl(String msgIdl) {
		MsgIdl = msgIdl;
	}
	
	
}
