package wx.sunl.model;

public class Button {
	//菜单按钮的响应动作类型
	private String type;
	//菜单按钮标题，不超过16个字节，子菜单不超过40个字节 
	private String name;
	//菜单按钮KEY值，用于消息接口推送，不超过128字节 
	private String key;
	//网页链接，用户点击菜单按钮可打开链接，不超过1024字节
	private String url;
	//调用新增永久素材接口返回的合法media_id 
	private String media_id;
	public Button() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	
	
}
