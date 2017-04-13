package wx.sunl.util;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import wx.sunl.model.Music;
import wx.sunl.model.Video;

/**
 * ��Ϣ��������
 * @author yangqing on 2017/04/13
 */
public class MessageHandlerUtil {
	/**
	 * ����΢�ŷ���������XML��
	 * @param request
	 * @return map
	 * @throws Exception
	 */
	public static Map<String,String> parseXml(HttpServletRequest request) throws Exception {
		// ����������洢��HashMap��
		Map<String, String> map = new HashMap<>();
		// ��request��ȡ��������
		InputStream inputStream = request.getInputStream();
		System.out.println("��ȡ������");
		// ��ȡ������
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// �õ�xml��Ԫ��
		Element root = document.getRootElement();
		// �õ���Ԫ�ص������ӽڵ�
		List<Element> elementList = root.elements();
		// ���������ӽڵ�
		for (Element e : elementList) {
			System.out.println(e.getName() + "|" + e.getText());
			map.put(e.getName(), e.getText());
		}
		// �ͷ���Դ
		inputStream.close();
		inputStream = null;
		return map;
	}
	
	/**
	 * ������Ϣ���͹���������Ϣ
	 * @param map
	 * @return
	 * @author yangqing 2017/04/13
	 */
	public static String buildResponseMessage(Map<String, String> map){
		//��Ӧ��Ϣ
		String responseMessage = "";
		//�õ���Ϣ����
		String msgType = map.get("MsgType").toString();
		//���ݶ����ö���ཫ��õ���Ϣ����ת��Ϊö�ٸ�ʽ
		MessageType messageEnumType = MessageType.valueOf(MessageType.class, msgType.toUpperCase());
		switch (messageEnumType) {
		case TEXT:
			//�����ı���Ϣ
			responseMessage = handleTextMessage(map);
			break;
		case IMAGE:
			//����ͼƬ��Ϣ
			/*responseMessage = handleImageMessage(map);---���ܴ�����*/
			break;
		case VOICE:
			//����������Ϣ
			/*responseMessage = handleVoiceMessage(map);---���ܴ�����*/
			break;
		case VIDEO:
			//������Ƶ��Ϣ
			/*responseMessage = handleVideoMessage(map);---���ܴ�����*/
			break;
		case SHORTVIDEO:
			//����С��Ƶ��Ϣ
			/*responseMessage = handleSmallVideoMessage(map);---���ܴ�����*/
			break;
		case LOCATION:
			//����λ����Ϣ
			/*responseMessage = handleLocationMessage(map);---���ܴ�����*/
			break;
		case LINK:
			//����������Ϣ
			/*responseMessage = handleLinkMessage(map);---���ܴ�����*/
			break;
		case EVENT:
			//�����¼���Ϣ,�û��ڹ�ע��ȡ����ע���ں�ʱ��΢�Ż������ǵĹ��ںŷ����������¼���Ϣ,�����߽��յ��¼���Ϣ��Ϳ��Ը��û��·���ӭ��
			responseMessage = handleEventMessage(map);
			break;
		default:
			break;
		}
		//������Ӧ��Ϣ
		return responseMessage;
	}
	
	/**
	 * �����ı���Ϣ
	 * @param map
	 * @param content
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildTextMessage(Map<String,String> map, String content) {
		//���ͷ��ʺ�
		String fromUserName = map.get("FromUserName");
		// ������΢�ź�
		String toUserName = map.get("ToUserName");
		return  String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[text]]></MsgType>" +
				"<Content><![CDATA[%s]]></Content>" + "</xml>", 
				toUserName, fromUserName, getUtcTime(), content);
	}
	
	/**
	 * ����ͼƬ��Ϣ
	 * @param map
	 * @param mediaId
	 * @return
	 * @author yangqing 2017/04/13
	 */
	public static String buildImageMessage(Map<String, String> map, Image image) {
		//���ͷ��ʺ�
		String fromUserName = map.get("FromUserName");
		// ������΢�ź�
		String toUserName = map.get("ToUserName");
		return String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[image]]></MsgType>" +
				"<PicUrl><![CDATA[%s]]></PicUrl>" +
				"<MediaId><![CDATA[%s]]></MediaId>" +
				"</xml>",
				toUserName, fromUserName, getUtcTime(), mediaId);
	}
	
	
	/**
	 * ����������Ϣ
	 * @param map
	 * @param music
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildMusicMessage(Map<String, String> map, Music music) {
		//���ͷ��ʺ�
		String fromUserName = map.get("FromUserName");
		// ������΢�ź�
		String toUserName = map.get("ToUserName");
		return String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[music]]></MsgType>" +
				"<Music>" +
				"   <Title><![CDATA[%s]]></Title>" +
				"   <Description><![CDATA[%s]]></Description>" +
				"   <MusicUrl><![CDATA[%s]]></MusicUrl>" +
				"   <HQMusicUrl><![CDATA[%s]]></HQMusicUrl>" +
				"</Music>" +
				"</xml>",
				toUserName, fromUserName, getUtcTime(), music.getTitle(), music.getDescription(), music.getMusicUrl(), music.getHqMusicUrl());
	}
	
	
	/**
	 * ������Ƶ��Ϣ
	 * @param map
	 * @param video
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildVideoMessage(Map<String, String> map, Video video) {
		//���ͷ��ʺ�
		String fromUserName = map.get("FromUserName");
		// ������΢�ź�
		String toUserName = map.get("ToUserName");
		return String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[video]]></MsgType>" +
				"<MediaId><![CDATA[%s]]></MediaId>" +
				"<ThumbMediaId><![CDATA[%s]]></ThumbMediaId>" +
				"</xml>",
				toUserName, fromUserName, getUtcTime(), video.getMediaId(), video.getThumbMediaId());
	}
	
	
	/**
	 * ����������Ϣ
	 * @param map
	 * @param mediaId
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildVoiceMessage(Map<String, String> map, String mediaId) {
		//���ͷ��ʺ�
		String fromUserName = map.get("FromUserName");
		// ������΢�ź�
		String toUserName = map.get("ToUserName");
		return String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[voice]]></MsgType>" +
				"<Voice>" +
				"   <MediaId><![CDATA[%s]]></MediaId>" +
				"</Voice>" +
				"</xml>",
				fromUserName, toUserName, getUtcTime(), mediaId);
	}
	
	
	/**
	 * ����ͼ����Ϣ
	 * @param map
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildNewsMessage(Map<String, String> map) {
		//���ͷ��ʺ�
		String fromUserName = map.get("FromUserName");
		// ������΢�ź�
		String toUserName = map.get("ToUserName");
		NewsItem item = new NewsItem();
		item.Title = "΢�ſ���ѧϰ�ܽᣨһ������΢�ſ��������";
		item.Description = "���������£�������������Ҫ��΢�Ź��ںſ�������ôҪ��׼���������ز����ٵĶ�����\n" +
				"\n" +
				"����1��Ҫ��һ���������ԵĹ��ںš�\n" +
				"\n" +
				"����2��������ʽ����Ŀ�������";
		item.PicUrl = "http://images2015.cnblogs.com/blog/289233/201601/289233-20160121164317343-2145023644.png";
		item.Url = "http://www.cnblogs.com/xdp-gacl/p/5149171.html";
		String itemContent1 = buildSingleItem(item);
		
		NewsItem item2 = new NewsItem();
		item2.Title = "΢�ſ���ѧϰ�ܽᣨ��������΢�ſ�������";
		item2.Description = "΢�ŷ��������൱��һ��ת�����������նˣ��ֻ���Pad�ȣ�����������΢�ŷ�������΢�ŷ�����Ȼ������ת�������ǵ�Ӧ�÷�������Ӧ�÷�����������Ϻ󣬽���Ӧ���ݻط���΢�ŷ�������΢�ŷ������ٽ�������Ӧ��Ϣ�ظ���΢��App�նˡ�";
		item2.PicUrl = "";
		item2.Url = "http://www.cnblogs.com/xdp-gacl/p/5151857.html";
		String itemContent2 = buildSingleItem(item2);
		String content = String.format("<xml>\n" +
				"<ToUserName><![CDATA[%s]]></ToUserName>\n" +
				"<FromUserName><![CDATA[%s]]></FromUserName>\n" +
				"<CreateTime>%s</CreateTime>\n" +
				"<MsgType><![CDATA[news]]></MsgType>\n" +
				"<ArticleCount>%s</ArticleCount>\n" +
				"<Articles>\n" + "%s" +
				"</Articles>\n" +
				"</xml> ", fromUserName, toUserName, getUtcTime(), 2, itemContent1 + itemContent2);
		return content;
	}
	
	/**
	 * ����ͼ����Ϣ��һ����¼
	 * @param item
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildSingleItem(NewsItem item) {
		String itemContent = String.format("<item>\n" +
				"<Title><![CDATA[%s]]></Title> \n" +
				"<Description><![CDATA[%s]]></Description>\n" +
				"<PicUrl><![CDATA[%s]]></PicUrl>\n" +
				"<Url><![CDATA[%s]]></Url>\n" +
				"</item>", item.Title, item.Description, item.PicUrl, item.Url);
		return itemContent;
	}
	
	/**
	 * ��ȡ��������ǰʱ�䣨ʱ������ͣ�
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String getUtcTime() {
		Date dt = new Date();// �������Ҫ��ʽ,��ֱ����dt,dt���ǵ�ǰϵͳʱ��
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmm");// ������ʾ��ʽ
		String nowTime = df.format(dt);
		long dd = (long) 0;
		try {
			dd = df.parse(nowTime).getTime();
		}catch (Exception e) {
			
		}
		return String.valueOf(dd);
	}
	
	/**
     * ���յ��ı���Ϣ����
     * @param map ��װ�˽��������Map
     * @return
     * @author yangqing 2017/04/13
     */
    private static String handleTextMessage(Map<String, String> map) {
        //��Ӧ��Ϣ
        String responseMessage;
        // ��Ϣ����
        String content = map.get("Content");
        switch (content) {
            case "�ı�":
                String msgText = "�°�������Ҫ��ʼд�����ܽ���,��ӭ�����Ƿ������ڲ���԰����д�Ĳ���\n" +
                        "<a href=\"http://www.cnblogs.com/xdp-gacl\">�°����ǵĲ���</a>";
                responseMessage = buildTextMessage(map, msgText);
                break;
            case "ͼƬ":
                //ͨ���زĹ���ӿ��ϴ�ͼƬʱ�õ���media_id
                String imgMediaId = "dSQCiEHYB-pgi7ib5KpeoFlqpg09J31H28rex6xKgwWrln3HY0BTsoxnRV-xC_SQ";
                responseMessage = buildImageMessage(map, imgMediaId);
                break;
            case "����":
                //ͨ���زĹ���ӿ��ϴ������ļ�ʱ�õ���media_id
                String voiceMediaId = "h3ul0TnwaRPut6Tl1Xlf0kk_9aUqtQvfM5Oq21unoWqJrwks505pkMGMbHnCHBBZ";
                responseMessage = buildVoiceMessage(map,voiceMediaId);
                break;
            case "ͼ��":
                responseMessage = buildNewsMessage(map);
                break;
            case "����":
                Music music = new Music();
                music.setTitle("����ӱ����־�� - ��������");
                music.setDescription("���Ӿ硶��ɽս�͡�����");
                music.setMusicUrl("http://gacl.ngrok.natapp.cn/music/music.mp3");
                music.setHqMusicUrl("http://gacl.ngrok.natapp.cn/music/music.mp3");
                responseMessage = buildMusicMessage(map, music);
                break;
            case "��Ƶ":
                Video video = new Video();
                video.setMediaId("GqmIGpLu41rtwaY7WCVtJAL3ZbslzKiuLEXfWIKYDnHXGObH1CBH71xtgrGwyCa3");
                video.setTitle("Сƻ��");
                video.setDescription("Сƻ����Ц��Ƶ");
                responseMessage = buildVideoMessage(map, video);
                break;
            default:
                responseMessage = buildWelcomeTextMessage(map);
                break;

        }
        //������Ӧ��Ϣ
        return responseMessage;
    }
	
}
