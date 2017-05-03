package wx.sunl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wx.sunl.bean.User;
import wx.sunl.dao.UserDao;
import wx.sunl.dao.Impl.UserDaoImpl;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		String country = request.getParameter("country");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String userAddr = country+province+city;
		if(null != phone && !phone.equals("")){
			User user = new User();
			user.setUserSex(sex);
			user.setUserPhoneNumber1(phone);
			user.setUserAddr(userAddr);
			UserDao userDao = new UserDaoImpl();
			boolean flag = userDao.saveOrUpdate(user, "save");
			if(flag){
				session.setAttribute("user", user);
				request.getRequestDispatcher("booking.jsp").forward(request, response);
			}else{
				String msg = "系统错误，请稍后重试！";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}else{
			String msg = "您必须输入有效联系方式才能进行预订操作！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("error.jsp").forward(request, response);
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
