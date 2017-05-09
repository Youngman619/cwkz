package wx.sunl.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import wx.sunl.model.Button;

public class ConstructMenuUtil {
	
	/**
	 * 构造自定义菜单的方法
	 * @return
	 */
	public JSONObject ConstructMenu(){
		//初始化菜单menu
		JSONObject menu = new JSONObject();
		//初始化存放菜单按钮的button json数组
		JSONArray button = new JSONArray();
		//初始化一级菜单按钮
		Button button1 = new Button();
		button1.setType("click");
		button1.setName("今日公告");
		button1.setKey("MESSAGE_TODAY_TEXT");
		Button button2 = new Button();
		button2.setType("view");
		button2.setName("酒店预订");
		button2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx90716ffab2e94997&redirect_uri=http://7x7t4u.natappfree.cc/voastudy/OAuthServlet&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		Button button3 = new Button();
		button3.setType("view");
		button3.setName("企业终端");
		button3.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx90716ffab2e94997&redirect_uri=http://7x7t4u.natappfree.cc/voastudy/OAuthTwoServlet&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		
		button.add(button1);
		button.add(button2);
		button.add(button3);
		
		menu.put("button", button);
		
		return menu;
	}
}
