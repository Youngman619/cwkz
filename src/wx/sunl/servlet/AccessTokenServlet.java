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
		System.out.println("启动WebServlet");
		super.init();
		
		final String appId = getInitParameter("appId");
		final String appSecret = getInitParameter("appSecret");
		
		
		//开启一个新线程（获取accessToken并根据accessToken创建自定义菜单）
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						//获取accessToken
						AccessTokenInfo.accessToken = getAccessToken(appId, appSecret);
						//获取成功
						if (AccessTokenInfo.accessToken != null) {
							createMenu(AccessTokenInfo.accessToken);
							//获取到access_token 休眠7000秒,大约2个小时左右
							Thread.sleep(7000 * 1000);
							//Thread.sleep(10 * 1000);//10秒钟获取一次
						}else{
							//获取失败
							Thread.sleep(1000 * 3); //获取的access_token为空 休眠3秒
						}
					} catch (InterruptedException e) {
						System.out.println("发生异常：" + e.getMessage());
						e.printStackTrace();
						try {
							Thread.sleep(1000 * 10); //发生异常休眠1秒
						}catch (Exception e1) {
							
						}
					}
				}				
			}
		}).start();
	}
	
	
	/**
	 * 获取accessToken的调用微信接口方法
	 * @param appId
	 * @param appSecret
	 * @return
	 */
	public static AccessToken getAccessToken(String appId, String appSecret) {
		NetWorkHelper netHelper = new NetWorkHelper();
		/**
		 * 接口地址为https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET，
		 * 其中grant_type固定写为client_credential即可
		 * */
		String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s",appId, appSecret);
		//此请求为https的get请求，返回的数据格式为{"access_token":"ACCESS_TOKEN","expires_in":7200}
		String result = netHelper.getHttpsResponse(Url, "");
		System.out.println("获取到的access_token="+result);
		//使用FastJson将Json字符串解析成Json对象
		JSONObject json = JSON.parseObject(result);
		AccessToken token = new AccessToken();
		token.setAccessToken(json.getString("access_token"));
		token.setExpiresin(json.getInteger("expires_in"));
		return token;
	}
	
	/**
	 * 创建自定义菜单的接口方法
	 * @param url
	 * @param menu
	 * @param requestType
	 */
	private void createMenu(AccessToken token){
		/**
		 * 接口地址为https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN，
		 * 其中ACCESS_TOKEN为在访问微信服务器调用微信接口方法获取到的accessToken
		 * */
		String url = String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", token.getAccessToken());
		//调用ConstructMenuUtil构造自定义菜单类获取到的ConstructMenu()方法获取菜单对象
		ConstructMenuUtil menuUtil = new ConstructMenuUtil();
		JSONObject menu = menuUtil.ConstructMenu();
		String menuJson = menu.toString();
		
		NetWorkHelper netWorkHelper = new NetWorkHelper();
		netWorkHelper.getHttpsResponseForCreateMenu(url, "POST", menuJson);
	}

}
