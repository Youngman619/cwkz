package wx.sunl.model;

public class Video {
	//��Ƶ�ļ�id��ʶ
	private String mediaId;
	//��Ƶ�ļ�����
	private String title;
	//��Ƶ�ļ�����
	private String description;
	//��Ƶ��Ϣ����ͼ��ý��id
	private String thumbMediaId; 
	
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	
	
}
