package wx.sunl.model;

public class Image {
	//ͼƬ�ļ�id��ʶ
	private String MediaId;
	//ͼƬ�ļ�����Url
	private String picUrl;
	//��Ϣid��ʶ
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
