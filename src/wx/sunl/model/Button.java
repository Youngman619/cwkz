package wx.sunl.model;

public class Button {
	//�˵���ť����Ӧ��������
	private String type;
	//�˵���ť���⣬������16���ֽڣ��Ӳ˵�������40���ֽ� 
	private String name;
	//�˵���ťKEYֵ��������Ϣ�ӿ����ͣ�������128�ֽ� 
	private String key;
	//��ҳ���ӣ��û�����˵���ť�ɴ����ӣ�������1024�ֽ�
	private String url;
	//�������������زĽӿڷ��صĺϷ�media_id 
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
