package wx.sunl.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CreateUUID {
	
	/**
	 * ����һ��������ظ���32λUUID�ַ���
	 * @return
	 */
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		// ȥ��"-"����
		String temp = str.substring(0, 8)+str.substring(9, 13)+str.substring(14, 18)+str.substring(19, 23)+str.substring(24);
		return temp;
	}
	
	public static Timestamp getTimestamp(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String date = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ�䣬Ҳ��ʹ�õ�ǰʱ���
		Timestamp timestamp = Timestamp.valueOf(date);
		return timestamp;
	}
	
	/**
	 * ����ǰϵͳʱ���ת��Ϊ14λ�ַ���
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
