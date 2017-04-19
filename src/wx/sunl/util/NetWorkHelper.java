package wx.sunl.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.*;

import com.alibaba.fastjson.JSONObject;

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
	
	/**
	 * 发送https请求获取网页授权
	 * @param requestUrl
	 * @param requestMethod
	 * @param params
	 * @return
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String params) {
        JSONObject jsonObject = null;
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {xtm};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);
            
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);

            // 当outputStr不为null时向输出流写数据
            if (null != params) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(params.getBytes("UTF-8"));
                outputStream.close();
            }

            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return jsonObject;
    }
	
	
	static X509TrustManager xtm = new X509TrustManager() {
		
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
