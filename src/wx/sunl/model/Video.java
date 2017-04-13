package wx.sunl.model;

public class Video {
	//视频文件id标识
	private String mediaId;
	//视频文件标题
	private String title;
	//视频文件描述
	private String description;
	//视频消息缩略图的媒体id
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
