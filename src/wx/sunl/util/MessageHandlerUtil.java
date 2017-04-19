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

import wx.sunl.model.Image;
import wx.sunl.model.Music;
import wx.sunl.model.Video;
import wx.sunl.model.Voice;

/**
 * 消息处理工具类
 * @author yangqing on 2017/04/13
 */
public class MessageHandlerUtil {
	/**
	 * 解析微信发来的请求（XML）
	 * @param request
	 * @return map
	 * @throws Exception
	 */
	public static Map<String,String> parseXml(HttpServletRequest request) throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();
		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		System.out.println("获取输入流");
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();
		// 遍历所有子节点
		for (Element e : elementList) {
			System.out.println(e.getName() + "|" + e.getText());
			map.put(e.getName(), e.getText());
		}
		// 释放资源
		inputStream.close();
		inputStream = null;
		return map;
	}

	/**
	 * 根据消息类型构建返回消息
	 * @param map
	 * @return
	 * @author yangqing 2017/04/13
	 */
	public static String buildResponseMessage(Map<String, String> map){
		//响应消息
		String responseMessage = "";
		//得到消息类型
		String msgType = map.get("MsgType").toString();
		//根据定义的枚举类将获得的消息类型转换为枚举格式
		MessageType messageEnumType = MessageType.valueOf(MessageType.class, msgType.toUpperCase());
		switch (messageEnumType) {
		case TEXT:
			String message = "感谢您关注“从吾客栈”酒店微信公众号，您的认可是对我们最大的鼓励！";
			//处理文本消息
			responseMessage = buildTextMessage(map, message);
			break;
		case IMAGE:
			//处理图片消息
			/*responseMessage = handleMessage(map);--功能待开发*/
			break;
		case VOICE:
			//处理语音消息
			/*responseMessage = handleMessage(map);--功能待开发*/
			break;
		case VIDEO:
			//处理视频消息
			/*responseMessage = handleMessage(map);--功能待开发*/
			break;
		case SHORTVIDEO:
			//处理小视频消息
			/*responseMessage = handleMessage(map);--功能待开发*/
			break;
		case LOCATION:
			//处理位置消息
			/*responseMessage = handleMessage(map);--功能待开发*/
			break;
		case LINK:
			//处理链接消息
			/*responseMessage = handleMessage(map);--功能待开发*/
			break;
		case EVENT:
			//处理事件消息,用户在关注与取消关注公众号时，微信会向我们的公众号服务器发送事件消息,开发者接收到事件消息后就可以给用户下发欢迎消
			responseMessage = handleEventMessage(map);
			break;
		default:
			break;
		}
		//返回响应消息
		return responseMessage;
	}
	
	public static String handleEventMessage(Map<String, String> map){
		//响应消息
		String responseMessage = "";
		//推送的欢迎语
		String welcomeMessage = "";
		//获取时间的类型
		String event = map.get("Event");
		switch (event) {
		case "subscribe":
			//关注事件
			welcomeMessage = "欢迎您关注“从吾客栈”酒店微信公众号！";
			responseMessage = buildWelcomeTextMessage(map, welcomeMessage);
			break;
		case "unsubscribe":
			//取消关注事件
			welcomeMessage = "感谢您关注“从吾客栈”酒店微信公众号，希望下一次的相遇，让您更加的满意！";
			responseMessage = buildWelcomeTextMessage(map, welcomeMessage);
			break;
		default:
			break;
		}
		return responseMessage;
	}
	
	public static String buildWelcomeTextMessage(Map<String, String> map, String welcomeMessage){
		//发送方帐号
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		return String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[text]]></MsgType>" +
				"<Content><![CDATA[%s]]></Content>" + 
				"</xml>", 
				fromUserName, toUserName, getUtcTime(), welcomeMessage);
	}
	
	/**
	 * 构造文本消息
	 * @param map
	 * @param content
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildTextMessage(Map<String,String> map, String content) {
		//发送方帐号
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		return  String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[text]]></MsgType>" +
				"<Content><![CDATA[%s]]></Content>" + "</xml>", 
				fromUserName, toUserName, getUtcTime(), content);
	}
	
	/**
	 * 构造图片消息
	 * @param map
	 * @param mediaId
	 * @return
	 * @author yangqing 2017/04/13
	 */
	public static String buildImageMessage(Map<String, String> map, Image image) {
		//发送方帐号
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		return String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[image]]></MsgType>" +
				"<PicUrl><![CDATA[%s]]></PicUrl>" +
				"<MediaId><![CDATA[%s]]></MediaId>" +
				"</xml>",
				fromUserName, toUserName, getUtcTime(), image.getPicUrl(), image.getMediaId());
	}
	
	
	/**
	 * 构造音乐消息
	 * @param map
	 * @param music
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildMusicMessage(Map<String, String> map, Music music) {
		//发送方帐号
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		return String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[music]]></MsgType>" +
				"<Music>" +
				"<Title><![CDATA[%s]]></Title>" +
				"<Description><![CDATA[%s]]></Description>" +
				"<MusicUrl><![CDATA[%s]]></MusicUrl>" +
				"<HQMusicUrl><![CDATA[%s]]></HQMusicUrl>" +
				"</Music>" +
				"</xml>",
				fromUserName, toUserName, getUtcTime(), music.getTitle(), music.getDescription(), music.getMusicUrl(), music.getHqMusicUrl());
	}
	
	
	/**
	 * 构造视频消息
	 * @param map
	 * @param video
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildVideoMessage(Map<String, String> map, Video video) {
		//发送方帐号
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		return String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[video]]></MsgType>" +
				"<MediaId><![CDATA[%s]]></MediaId>" +
				"<ThumbMediaId><![CDATA[%s]]></ThumbMediaId>" +
				"</xml>",
				fromUserName, toUserName, getUtcTime(), video.getMediaId(), video.getThumbMediaId());
	}
	
	
	/**
	 * 构造语音消息
	 * @param map
	 * @param mediaId
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String buildVoiceMessage(Map<String, String> map, Voice voice) {
		//发送方帐号
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		return String.format("<xml>" +
				"<ToUserName><![CDATA[%s]]></ToUserName>" +
				"<FromUserName><![CDATA[%s]]></FromUserName>" +
				"<CreateTime>%s</CreateTime>" +
				"<MsgType><![CDATA[voice]]></MsgType>" +
				"<MediaId><![CDATA[%s]]></MediaId>" +
				"<Format><![CDATA[%s]]></Format>" +
				"</xml>",
				fromUserName, toUserName, getUtcTime(), voice.getMediaId(), voice.getFormat());
	}
	
	
	/**
	 * 构造图文消息
	 * @param map
	 * @return
	 * @author yangqing 2017/04/13
	 */
	/*---------------------------------------功能待开发-------------------------------------------*/
	/*private static String buildNewsndMessage(Map<String, String> map) {
		//发送方帐号
		String fromUserName = map.get("FromUserName");
		// 开发者微信号
		String toUserName = map.get("ToUserName");
		NewsItem item = new NewsItem();
		item.Title = "微信开发学习总结（一）——微信开发环境搭建";
		item.Description = "工欲善其事，必先利其器。要做微信公众号开发，那么要先准备好两样必不可少的东西：\n" +
				"\n" +
				"　　1、要有一个用来测试的公众号。\n" +
				"\n" +
				"　　2、用来调式代码的开发环境";
		item.PicUrl = "http://images2015.cnblogs.com/blog/289233/201601/289233-20160121164317343-2145023644.png";
		item.Url = "http://www.cnblogs.com/xdp-gacl/p/5149171.html";
		String itemContent1 = buildSingleItem(item);
		
		NewsItem item2 = new NewsItem();
		item2.Title = "微信开发学习总结（二）——微信开发入门";
		item2.Description = "微信服务器就相当于一个转发服务器，终端（手机、Pad等）发起请求至微信服务器，微信服务器然后将请求转发给我们的应用服务器。应用服务器处理完毕后，将响应数据回发给微信服务器，微信服务器再将具体响应信息回复到微信App终端。";
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
	}*/
	
	/**
	 * 生成图文消息的一条记录
	 * @param item
	 * @return
	 * @author yangqing 2017/04/13
	 */
	/*---------------------------------------功能待开发-------------------------------------------*/
	/*private static String buildSingleItem(NewsItem item) {
		String itemContent = String.format("<item>\n" +
				"<Title><![CDATA[%s]]></Title> \n" +
				"<Description><![CDATA[%s]]></Description>\n" +
				"<PicUrl><![CDATA[%s]]></PicUrl>\n" +
				"<Url><![CDATA[%s]]></Url>\n" +
				"</item>", item.Title, item.Description, item.PicUrl, item.Url);
		return itemContent;
	}*/
	
	/**
	 * 获取服务器当前时间（时间戳类型）
	 * @return
	 * @author yangqing 2017/04/13
	 */
	private static String getUtcTime() {
		Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmm");// 设置显示格式
		String nowTime = df.format(dt);
		long dd = (long) 0;
		try {
			dd = df.parse(nowTime).getTime();
		}catch (Exception e) {
			
		}
		return String.valueOf(dd);
	}
	
	/**
     * 接收到文本消息后处理
     * @param map 封装了解析结果的Map
     * @return
     * @author yangqing 2017/04/13
     */
	/*private static String handleTextMessage(Map<String, String> map) {
        //响应消息
        String responseMessage = "";
        // 消息内容
        String content = map.get("Content");
        switch (content) {
            case "文本":
                String msgText = "欢迎您关注“从吾客栈”微信公众号，我们将为您提供便捷的酒店入住预订功能！";
                responseMessage = buildTextMessage(map, msgText);
                break;
            case "图片":
                //通过素材管理接口上传图片时得到的media_id
                //responseMessage = buildImageMessage(map, image);
                break;
            case "语音":
                //通过素材管理接口上传语音文件时得到的media_id
                //responseMessage = buildVoiceMessage(map,voice);
                break;
            case "图文":
                //responseMessage = buildNewsMessage(map, news);
                break;
            case "音乐":
                Music music = new Music();
                music.setTitle("赵丽颖、许志安 - 乱世俱灭");
                music.setDescription("电视剧《蜀山战纪》插曲");
                music.setMusicUrl("http://gacl.ngrok.natapp.cn/music/music.mp3");
                music.setHqMusicUrl("http://gacl.ngrok.natapp.cn/music/music.mp3");
                responseMessage = buildMusicMessage(map, music);
                break;
            case "视频":
                Video video = new Video();
                video.setMediaId("GqmIGpLu41rtwaY7WCVtJAL3ZbslzKiuLEXfWIKYDnHXGObH1CBH71xtgrGwyCa3");
                video.setTitle("小苹果");
                video.setDescription("小苹果搞笑视频");
                responseMessage = buildVideoMessage(map, video);
                break;
            default:
            	String welcomeMessage = "感谢您关注从吾客栈微信公众号，我们后续为您提供更方便更快捷的功能，敬请您的期待！";
                responseMessage = buildWelcomeTextMessage(map, welcomeMessage);
                break;
        }
        //返回响应消息
        return responseMessage;
    }*/
	
}
