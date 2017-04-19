package wx.sunl.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import wx.sunl.common.AccessTokenInfo;
import wx.sunl.entry.AccessToken;
import wx.sunl.util.ConstructMenuUtil;
import wx.sunl.util.NetWorkHelper;

/**
 * Servlet implementation class AccessTokenServlet
 */
public class AccessTokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessTokenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("����WebServlet");
		super.init();
		
		final String appId = getInitParameter("appId");
		final String appSecret = getInitParameter("appSecret");
		
		
		//����һ�����̣߳���ȡaccessToken������accessToken�����Զ���˵���
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						//��ȡaccessToken
						AccessTokenInfo.accessToken = getAccessToken(appId, appSecret);
						//��ȡ�ɹ�
						if (AccessTokenInfo.accessToken != null) {
							createMenu(AccessTokenInfo.accessToken);
							//��ȡ��access_token ����7000��,��Լ2��Сʱ����
							Thread.sleep(7000 * 1000);
							//Thread.sleep(10 * 1000);//10���ӻ�ȡһ��
						}else{
							//��ȡʧ��
							Thread.sleep(1000 * 3); //��ȡ��access_tokenΪ�� ����3��
						}
					} catch (InterruptedException e) {
						System.out.println("�����쳣��" + e.getMessage());
						e.printStackTrace();
						try {
							Thread.sleep(1000 * 10); //�����쳣����1��
						}catch (Exception e1) {
							
						}
					}
				}				
			}
		}).start();
	}
	
	
	/**
	 * ��ȡaccessToken�ĵ���΢�Žӿڷ���
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public static AccessToken getAccessToken(String appId, String appSecret) {
		NetWorkHelper netHelper = new NetWorkHelper();
		/**
		 * �ӿڵ�ַΪhttps://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET��
		 * ����grant_type�̶�дΪclient_credential����
		 * */
		String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",appId, appSecret);
		//������Ϊhttps��get���󣬷��ص����ݸ�ʽΪ{"access_token":"ACCESS_TOKEN","expires_in":7200}
		String result = netHelper.getHttpsResponse(Url, "");
		System.out.println("��ȡ����access_token="+result);
		//ʹ��FastJson��Json�ַ���������Json����
		JSONObject json = JSON.parseObject(result);
		AccessToken token = new AccessToken();
		token.setAccessToken(json.getString("access_token"));
		token.setExpiresin(json.getInteger("expires_in"));
		return token;
	}
	
	/**
	 * �����Զ���˵��Ľӿڷ���
	 * @param url
	 * @param menu
	 * @param requestType
	 */
	private void createMenu(AccessToken token){
		/**
		 * �ӿڵ�ַΪhttps://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN��
		 * ����ACCESS_TOKENΪ�ڷ���΢�ŷ���������΢�Žӿڷ�����ȡ����accessToken
		 * */
		String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", token.getAccessToken());
		//����ConstructMenuUtil�����Զ���˵����ȡ����ConstructMenu()������ȡ�˵�����
		ConstructMenuUtil menuUtil = new ConstructMenuUtil();
		JSONObject menu = menuUtil.ConstructMenu();
		String menuJson = menu.toString();
		
		NetWorkHelper netWorkHelper = new NetWorkHelper();
		netWorkHelper.getHttpsResponseForCreateMenu(url, "POST", menuJson);
	}

}
