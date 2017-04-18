package wx.sunl.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import wx.sunl.model.Button;

public class ConstructMenuUtil {
	
	/**
	 * �����Զ���˵��ķ���
	 * @return
	 */
	public JSONObject ConstructMenu(){
		//��ʼ���˵�menu
		JSONObject menu = new JSONObject();
		//��ʼ����Ų˵���ť��button json����
		JSONArray button = new JSONArray();
		//��ʼ��һ���˵���ť
		Button button1 = new Button();
		button1.setType("click");
		button1.setName("���չ���");
		button1.setKey("MESSAGE_TODAY_TEXT");
		Button button2 = new Button();
		button2.setType("view");
		button2.setName("�ͻ�����");
		button2.setUrl("https://www.baidu.com");
		Button button3 = new Button();
		button3.setType("view");
		button3.setName("�������");
		button3.setUrl("http://ip262h.natappfree.cc/voastudy/WebContent/index.jsp");
		
		button.add(button1);
		button.add(button2);
		button.add(button3);
		
		menu.put("button", button);
		
		return menu;
	}
}
