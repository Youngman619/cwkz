package wx.sunl.entry;


/**
 * AccessToken������ģ��
 * Created by yangqing on 2017/04/13
 * */
public class AccessToken {
	
	//��ȡ����ƾ֤
	private String accessToken;
	//ƾ֤��Чʱ�䣬��λ����
	private int expiresin;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public int getExpiresin() {
		return expiresin;
	}
	public void setExpiresin(int expiresin) {
		this.expiresin = expiresin;
	}
	
	
}
