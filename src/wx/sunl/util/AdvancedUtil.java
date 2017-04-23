package wx.sunl.util;


import com.alibaba.fastjson.JSONObject;

import wx.sunl.entry.WeixinOauth2Token;
import wx.sunl.model.SNSUserInfo;

public class AdvancedUtil {
	/**
	 * ��ȡ��ҳ��Ȩƾ֤
	 * @param requestUrl
	 * @param requestMethod
	 * @return
	 */
	public static WeixinOauth2Token getOauth2AccessToken(String requestUrl, String requestMethod){
		WeixinOauth2Token wat = null;
		// ��ȡ��ҳ��Ȩƾ֤
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
				 System.out.println("��ȡ��ҳ��Ȩƾ֤ʧ�� errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}");
			}
        }
        return wat;
	}
	
	public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
        SNSUserInfo snsUserInfo = null;
        // ƴ�������ַ
        String requestUrl = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=zh_CN", accessToken, openId);
        // ͨ����ҳ��Ȩ��ȡ�û���Ϣ
        JSONObject jsonObject = NetWorkHelper.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                snsUserInfo = new SNSUserInfo();
                // �û��ı�ʶ
                snsUserInfo.setOpenId(jsonObject.getString("openid"));
                // �ǳ�
                snsUserInfo.setNickname(jsonObject.getString("nickname"));
                // �Ա�1�����ԣ�2��Ů�ԣ�0��δ֪��
                snsUserInfo.setSex(jsonObject.getString("sex"));
                // �û����ڹ���
                snsUserInfo.setCountry(jsonObject.getString("country"));
                // �û�����ʡ��
                snsUserInfo.setProvince(jsonObject.getString("province"));
                // �û����ڳ���
                snsUserInfo.setCity(jsonObject.getString("city"));
                // �û�ͷ��
                snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
                // �û���Ȩ��Ϣ
                //snsUserInfo.setPrivilegeList(JSONArray.to(jsonObject.getJSONArray("privilege"), List.class));
            } catch (Exception e) {
                snsUserInfo = null;
                int errorCode = jsonObject.getIntValue("errcode");
                String errorMsg = jsonObject.getString("errmsg");
                System.out.println("��ȡ��ҳ��Ȩƾ֤ʧ�� errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}");
            }
        }
        return snsUserInfo;
    }
}
