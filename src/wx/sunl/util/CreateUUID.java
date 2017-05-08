package wx.sunl.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CreateUUID {
	
	/**
	 * 生成一个随机不重复的32位UUID字符串
	 * @return
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// 去掉"-"符号
		String temp = str.substring(0, 8)+str.substring(9, 13)+str.substring(14, 18)+str.substring(19, 23)+str.substring(24);
		return temp;
	}
	
	public static Timestamp getTimestamp(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		Timestamp timestamp = Timestamp.valueOf(date);
		return timestamp;
	}
	
	/**
	 * 将当前系统时间戳转换为14位字符串
	 * @return
	 */
	public static String getOrderNo(){
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=formatter.format(date);
		String str1 = time.substring(0, 4);
		String str2 = time.substring(5, 7);
		String str3 = time.substring(8, 10);
		String str4 = time.substring(11, 13);
		String str5 = time.substring(14, 16);
		String str6 = time.substring(17);
		String orderNo = str1+str2+str3+str4+str5+str6;
		return orderNo;
	}
}
