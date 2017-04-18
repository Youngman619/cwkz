package wx.sunl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.*;

public class NetWorkHelper {

	/**
	 * ����Https����(��ȡaccess_token��΢�ŷ�������Ӧ���)
	 * @param reqUrl �����URL��ַ
	 * @param requestMethod
	 * @return ��Ӧ����ַ���
	 */
	public String getHttpsResponse(String reqUrl, String requestMethod) {
		URL url;
		InputStream is;
		String resultData = "";
		
		try {
			url = new URL(reqUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			TrustManager[] tm = {xtm};
			
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, tm, null);
			
			con.setSSLSocketFactory(ctx.getSocketFactory());
			con.setHostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String arg0, SSLSession arg1) {
					return true;
				}
			});
			con.setDoInput(true); //����������������������
			//��android�б��뽫��������Ϊfalse
			con.setDoOutput(false); //������������������ϴ�
			con.setUseCaches(false); //��ʹ�û���
			if (null != requestMethod && !requestMethod.equals("")) {
				con.setRequestMethod(requestMethod); //ʹ��ָ���ķ�ʽ
			}else{
				con.setRequestMethod("GET"); //ʹ��get����
			}
			is = con.getInputStream();   //��ȡ����������ʱ��������������
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bufferReader = new BufferedReader(isr);
			String inputLine;
			while ((inputLine = bufferReader.readLine()) != null) {
				resultData += inputLine + "\n";
			}
			System.out.println(resultData);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resultData;
	}
	
	/**
	 * ����Https����(��ȡ�Զ���˵���΢�ŷ�������Ӧ���)
	 * @param reqUrl
	 * @param requestMethod
	 * @param params
	 */
	public void getHttpsResponseForCreateMenu(String reqUrl, String requestMethod, String params){
		URL url;
		InputStream is;
		OutputStream out;
		StringBuffer bufferRes = new StringBuffer();
		try {
			url = new URL(reqUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			// ���ӳ�ʱ
			con.setConnectTimeout(25000);
            // ��ȡ��ʱ --��������Ӧ�Ƚ���������ʱ��
			con.setReadTimeout(25000);
			
			con.setDoOutput(true);
			con.setUseCaches(false);
            if (null != requestMethod && !requestMethod.equals("")) {
				con.setRequestMethod(requestMethod); //ʹ��ָ���ķ�ʽ
			}else{
				con.setRequestMethod("GET"); //ʹ��get����
			}
            // ��ȡURLConnection�����Ӧ�������
            out = con.getOutputStream();
            // �����������
            out.write(params.getBytes("UTF-8"));
            out.flush();
            con.connect();
            is = con.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String inputLine = null;
			while ((inputLine = read.readLine()) != null) {
				bufferRes.append(inputLine);
			}
			System.out.println(bufferRes.toString());
			is.close();
			if (con != null) {
                // �ر�����
                con.disconnect();
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	X509TrustManager xtm = new X509TrustManager() {
		
		@Override
		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			// TODO Auto-generated method stub
		}
		
		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			// TODO Auto-generated method stub
		}
	};
}
