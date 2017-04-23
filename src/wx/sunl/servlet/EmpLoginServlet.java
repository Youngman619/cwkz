package wx.sunl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.StringUtils;

import wx.sunl.dao.EmployeeDao;
import wx.sunl.dao.impl.EmployeeDaoImpl;
import wx.sunl.dao.impl.RoomDaoImpl;
import wx.sunl.model.Employee;
import wx.sunl.model.EmployeeAccount;
import wx.sunl.model.Room;

/**
 * Servlet implementation class EmpLoginServlet
 */
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		if (!StringUtils.isNullOrEmpty(account) && !StringUtils.isNullOrEmpty(passwd)) {
			session.setAttribute("account", account);
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			EmployeeAccount empAccount = new EmployeeAccount();
			empAccount = empDao.login(account, passwd);
			if(null != empAccount && null != empAccount.getEmpAccountId()){
				RoomDaoImpl roomDaoImpl = new RoomDaoImpl();
				session.setAttribute("empAccount", empAccount);
				List<Room> roomList = roomDaoImpl.queryAllRoom();
				request.setAttribute("roomList", roomList);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				String msg = "用户不存在，请确认您的输入的信息是否正确！";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
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
