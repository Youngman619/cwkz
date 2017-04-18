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
	 * 发起Https请求(获取access_token的微信服务器响应结果)
	 * @param reqUrl 请求的URL地址
	 * @param requestMethod
	 * @return 响应后的字符串
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
			con.setDoInput(true); //允许输入流，即允许下载
			//在android中必须将此项设置为false
			con.setDoOutput(false); //允许输出流，即允许上传
			con.setUseCaches(false); //不使用缓冲
			if (null != requestMethod && !requestMethod.equals("")) {
				con.setRequestMethod(requestMethod); //使用指定的方式
			}else{
				con.setRequestMethod("GET"); //使用get请求
			}
			is = con.getInputStream();   //获取输入流，此时才真正建立链接
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
	 * 发起Https请求(获取自定义菜单的微信服务器响应结果)
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
			// 连接超时
			con.setConnectTimeout(25000);
            // 读取超时 --服务器响应比较慢，增大时间
			con.setReadTimeout(25000);
			
			con.setDoOutput(true);
			con.setUseCaches(false);
            if (null != requestMethod && !requestMethod.equals("")) {
				con.setRequestMethod(requestMethod); //使用指定的方式
			}else{
				con.setRequestMethod("GET"); //使用get请求
			}
            // 获取URLConnection对象对应的输出流
            out = con.getOutputStream();
            // 发送请求参数
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
                // 关闭连接
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
