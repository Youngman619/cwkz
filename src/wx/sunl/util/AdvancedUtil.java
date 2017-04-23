package wx.sunl.util;


import com.alibaba.fastjson.JSONObject;

import wx.sunl.entry.WeixinOauth2Token;
import wx.sunl.model.SNSUserInfo;

public class AdvancedUtil {
	/**
	 * 获取网页授权凭证
	 * @param requestUrl
	 * @param requestMethod
	 * @return
	 */
	public static WeixinOauth2Token getOauth2AccessToken(String requestUrl, String requestMethod){
		WeixinOauth2Token wat = null;
		// 获取网页授权凭证
        JSONObject jsonObject = NetWorkHelper.httpsRequest(requestUrl, requestMethod, null);
        if (null != jsonObject) {
        	try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getIntValue("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				 wat = null;
				 int errorCode = jsonObject.getIntValue("errcode");
				 String errorMsg = jsonObject.getString("errmsg");
				 System.out.println("获取网页授权凭证失败 errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}");
			}
        }
        return wat;
	}
	
	public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
        SNSUserInfo snsUserInfo = null;
        // 拼接请求地址
        String requestUrl = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", accessToken, openId);
        // 通过网页授权获取用户信息
        JSONObject jsonObject = NetWorkHelper.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                snsUserInfo = new SNSUserInfo();
                // 用户的标识
                snsUserInfo.setOpenId(jsonObject.getString("openid"));
                // 昵称
                snsUserInfo.setNickname(jsonObject.getString("nickname"));
                // 性别（1是男性，2是女性，0是未知）
                snsUserInfo.setSex(jsonObject.getString("sex"));
                // 用户所在国家
                snsUserInfo.setCountry(jsonObject.getString("country"));
                // 用户所在省份
                snsUserInfo.setProvince(jsonObject.getString("province"));
                // 用户所在城市
                snsUserInfo.setCity(jsonObject.getString("city"));
                // 用户头像
                snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
                // 用户特权信息
                //snsUserInfo.setPrivilegeList(JSONArray.to(jsonObject.getJSONArray("privilege"), List.class));
            } catch (Exception e) {
                snsUserInfo = null;
                int errorCode = jsonObject.getIntValue("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                System.out.println("获取网页授权凭证失败 errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}");
            }
        }
        return snsUserInfo;
    }
}
