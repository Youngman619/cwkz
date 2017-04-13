package wx.sunl.model;

public class Music {
	//音乐文件唯一标识
	private String musicId;
	//音乐文件标题
	private String title;
	//音乐文件描述
	private String description;
	//标准音乐文件路径
	private String musicUrl;
	//高品质音乐文件路径
	private String hqMusicUrl;
	
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMusicId() {
		return musicId;
	}

	public void setMusicId(String musicId) {
		this.musicId = musicId;
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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}
	
	
}
