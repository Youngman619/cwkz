package wx.sunl.util;

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
	
/*	public static void main(String[] args) {
		for (int i = 0; i < 14; i++) {
			String uuid = getUUID();
			System.out.println(uuid);
		}
	}*/
}
