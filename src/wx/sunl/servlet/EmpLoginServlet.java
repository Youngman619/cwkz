package wx.sunl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.StringUtils;

import wx.sunl.bean.Employee;
import wx.sunl.bean.EmployeeAccount;
import wx.sunl.bean.Room;
import wx.sunl.dao.*;
import wx.sunl.dao.impl.EmployeeDaoImpl;
import wx.sunl.dao.impl.RoomDaoImpl;

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
			EmployeeDao empDao = new EmployeeDaoImpl();
			EmployeeAccount empAccount = new EmployeeAccount();
			empAccount = empDao.login(account, passwd);
			if(null != empAccount && null != empAccount.getEmpAccountId()){
				//��ѯԱ��������Ϣ����
				Employee employee = empDao.findById(empAccount.getEmpId());
				if(null != employee){
					session.setAttribute("employee", employee);
				}
				//��ѯ��������
				RoomDao roomDao = new RoomDaoImpl();
				session.setAttribute("empAccount", empAccount);
				List<Room> roomList = roomDao.queryAllRoom();
				//��ѯ��������
				
				request.setAttribute("roomList", roomList);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{
				String msg = "�û������ڣ���ȷ�������������Ϣ�Ƿ���ȷ��";
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
