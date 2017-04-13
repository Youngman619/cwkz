package wx.sunl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wx.sunl.util.MessageHandlerUtil;
import wx.sunl.util.SignUtil;

/**
 * Servlet implementation class CoreServlet
 */
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//微信加密签名
		String signature  = request.getParameter("signature");
		//时间戳
		String timestamp = request.getParameter("timestamp");
		//随机数
		String nonce = request.getParameter("nonce");
		//随机字符串
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		// 通过检验 signature 对请求进行校验，若校验成功则原样返回 echostr，表示接入成功，否则接入失败
		if(SignUtil.checkSignature(signature, timestamp, nonce)){
	           out.print(echostr);
	    }
		out.close();
		out = null; 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/* 处理微信服务器发来的消息
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 接收、处理、响应由微信服务器转发的用户发送给公众帐号的消息
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("请求进入");
		String responseMsg = "";
		try {
			//解析微信发来的请求,将解析后的结果封装成Map返回
			Map<String,String> map = MessageHandlerUtil.parseXml(request);
			System.out.println("开始构造消息");
			responseMsg = MessageHandlerUtil.buildResponseMessage(map);
			System.out.println(responseMsg);
			if(responseMsg.equals("")){
				responseMsg = "未正确响应";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("发生异常："+ e.getMessage());
			responseMsg ="未正确响应";
		}
		//发送响应信息
		response.getWriter().println(responseMsg);
	}

}
