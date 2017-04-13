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
		//΢�ż���ǩ��
		String signature  = request.getParameter("signature");
		//ʱ���
		String timestamp = request.getParameter("timestamp");
		//�����
		String nonce = request.getParameter("nonce");
		//����ַ���
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		// ͨ������ signature ���������У�飬��У��ɹ���ԭ������ echostr����ʾ����ɹ����������ʧ��
		if(SignUtil.checkSignature(signature, timestamp, nonce)){
	           out.print(echostr);
	    }
		out.close();
		out = null; 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/* ����΢�ŷ�������������Ϣ
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ���ա�������Ӧ��΢�ŷ�����ת�����û����͸������ʺŵ���Ϣ
		// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("�������");
		String responseMsg = "";
		try {
			//����΢�ŷ���������,��������Ľ����װ��Map����
			Map<String,String> map = MessageHandlerUtil.parseXml(request);
			System.out.println("��ʼ������Ϣ");
			responseMsg = MessageHandlerUtil.buildResponseMessage(map);
			System.out.println(responseMsg);
			if(responseMsg.equals("")){
				responseMsg = "δ��ȷ��Ӧ";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�����쳣��"+ e.getMessage());
			responseMsg ="δ��ȷ��Ӧ";
		}
		//������Ӧ��Ϣ
		response.getWriter().println(responseMsg);
	}

}
