package wx.sunl.model;

public class Music {
	//�����ļ�Ψһ��ʶ
	private String musicId;
	//�����ļ�����
	private String title;
	//�����ļ�����
	private String description;
	//��׼�����ļ�·��
	private String musicUrl;
	//��Ʒ�������ļ�·��
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
