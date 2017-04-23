package wx.sunl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.StringUtils;

import wx.sunl.dao.EmployeeDao;
import wx.sunl.dao.impl.EmployeeDaoImpl;
import wx.sunl.model.Employee;

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
			Employee emp = new Employee();
			emp = empDao.login(account, passwd);
			if(null != emp && null != emp.getEmpId()){
				session.setAttribute("emp", emp);
				response.sendRedirect("index.jsp") ;
			}else{
				String msg = "�û������ڣ���ȷ�������������Ϣ�Ƿ���ȷ��";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("login.jsp").forward(request, response);
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
