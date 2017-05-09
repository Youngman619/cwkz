package wx.sunl.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wx.sunl.bean.Advice;
import wx.sunl.dao.AdviceDao;
import wx.sunl.dao.impl.AdviceDaoImpl;
import wx.sunl.util.CreateUUID;

/**
 * Servlet implementation class AdviceServlet
 */
public class AdviceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdviceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if(method.equals("add")){
        	Advice advice = new Advice();
    		String adviceId = CreateUUID.getUUID();
    		String imgUrl1 = request.getParameter("url0");
    		String imgUrl2 = request.getParameter("url1");
    		String imgUrl3 = request.getParameter("url2");
    		String imgUrl4 = request.getParameter("url3");
    		String adviceContent = request.getParameter("adviceContent");
    		Timestamp createTime = CreateUUID.getTimestamp();
    		String userId = request.getParameter("userId");
    		String userName = request.getParameter("userName");
    		advice.setAdviceId(adviceId);
    		advice.setImgUrl01(imgUrl1);
    		advice.setImgUrl02(imgUrl2);
    		advice.setImgUrl03(imgUrl3);
    		advice.setImgUrl04(imgUrl4);
    		advice.setAdviceContent(adviceContent);
    		advice.setCreateTime(createTime);
    		advice.setUserId(userId);
    		advice.setUserName(userName);
    		AdviceDao adviceDao = new AdviceDaoImpl();
    		boolean flag = adviceDao.save(advice);
    		if(flag){
    			String msg = "感谢您提供宝贵的建议，我们将努力为您提供更舒适的入住体验！";
    			request.setAttribute("msg", msg);
    			request.getRequestDispatcher("success.jsp").forward(request, response);
    		}else{
    			String msg = "系统繁忙，请稍后再试！";
    			request.setAttribute("msg", msg);
    			request.getRequestDispatcher("error.jsp").forward(request, response);
    		}
        }
        if(method.equals("queryAll")){
        	AdviceDao adviceDao = new AdviceDaoImpl();
        	List<Advice> adviceList = adviceDao.queryAllAdvice();
        	request.setAttribute("adviceList", adviceList);
        	request.getRequestDispatcher("adviceList.jsp").forward(request, response);
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
