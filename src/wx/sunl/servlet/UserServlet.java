package wx.sunl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wx.sunl.bean.User;
import wx.sunl.dao.UserDao;
import wx.sunl.dao.impl.UserDaoImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
        if(method.equals("updateForUsers")){
        	HttpSession session =  request.getSession();
    		User user = new User();
    		String userId = request.getParameter("userId");
    		String userName = request.getParameter("userName");
    		String userSex = request.getParameter("userSex");
    		String userIDCard = request.getParameter("userIDCard");
    		String userPhoneNumber1 = request.getParameter("userPhoneNumber1");
    		String userAddr = request.getParameter("userAddr");
    		user.setUserId(userId);
    		user.setUserName(userName);
    		user.setUserSex(userSex);
    		user.setUserIDCard(userIDCard);
    		user.setUserPhoneNumber1(userPhoneNumber1);
    		user.setUserAddr(userAddr);
    		UserDao userDao = new UserDaoImpl();
    		boolean flag = userDao.saveOrUpdate(user, "update");
    		if(flag){
    			session.setAttribute("user", user);
    			String msg = "您的个人信息修改成功！";
    			request.setAttribute("msg", msg);
    			request.getRequestDispatcher("success.jsp").forward(request, response);
    		}else{
    			String msg = "您的个人信息修改失败！";
    			request.setAttribute("msg", msg);
    			request.getRequestDispatcher("error.jsp").forward(request, response);
    		}
        }
        if(method.equals("queryAll")){
        	UserDao userDao = new UserDaoImpl();
			List<User> userList = userDao.queryAllUesr();
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("userList.jsp").forward(request, response);
        }
        if(method.equals("queryOne")){
        	String userId = request.getParameter("userId");
        	UserDao userDao = new UserDaoImpl();
        	User user = userDao.findById(userId);
        	request.setAttribute("user", user);
        	request.getRequestDispatcher("userInfo.jsp").forward(request, response);
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
