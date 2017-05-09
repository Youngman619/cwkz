package wx.sunl.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;

import wx.sunl.bean.Orders;
import wx.sunl.dao.OrdersDao;
import wx.sunl.dao.impl.OrdersDaoImpl;
import wx.sunl.util.CreateUUID;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
		OrdersDao ordersDao = new OrdersDaoImpl();
		Orders orders = null;
		boolean flag = false;
		String method = request.getParameter("method");
		if(method.equals("save")){
			orders = new Orders();
			Timestamp checkInTime = null;
			Timestamp checkOutTime = null;
			String userId = request.getParameter("userId");
			String userName = request.getParameter("userName");
			String orderId = CreateUUID.getUUID();
			String orderNo = CreateUUID.getOrderNo();
			String roomType = request.getParameter("roomType");
			if(!StringUtils.isNullOrEmpty(request.getParameter("checkInTime"))){
				checkInTime = Timestamp.valueOf(request.getParameter("checkInTime")+" 00:00:00");
			}
			if(!StringUtils.isNullOrEmpty(request.getParameter("checkOutTime"))){
				checkOutTime = Timestamp.valueOf(request.getParameter("checkOutTime")+" 00:00:00");
			}
			String remark = request.getParameter("remark");
			Timestamp createTime = CreateUUID.getTimestamp();
			orders.setOrderId(orderId);
			orders.setRoomType(roomType);
			orders.setCheckInTime(checkInTime);
			orders.setCheckOutTime(checkOutTime);
			orders.setRemark(remark);
			orders.setOrderNo(orderNo);
			orders.setCreateTime(createTime);
			orders.setUserId(userId);
			orders.setUserName(userName);
			orders.setOrderStatus("0");//OrderStatus--0 待处理；OrderStatus--1 已处理 
			flag = ordersDao.saveOrUpdate(orders, method);
			if(flag){
				String msg = "您的订单已提交，等待受理！";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				String msg = "系统繁忙，请稍后再试！";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		if(method.equals("update")){
			orders = new Orders();
			String orderId = request.getParameter("orderId");
			String orderStatus = request.getParameter("orderStatus");
			String roomType = request.getParameter("roomType");
			String roomId = request.getParameter("roomId");
			String empId = request.getParameter("empId");
			String empNo = request.getParameter("empNo");
			orders.setOrderId(orderId);
			orders.setOrderStatus(orderStatus);
			orders.setRoomType(roomType);
			orders.setRoomId(roomId);
			orders.setEmpId(empId);
			orders.setEmpNo(empNo);
			flag = ordersDao.saveOrUpdate(orders, method);
			if(flag){
				String msg = "订单处理成功";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else{
				String msg = "系统繁忙，请稍后再试！";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		}
		if(method.equals("queryOne")){
			String orderId = request.getParameter("orderId");
			orders = ordersDao.findById(orderId);
			request.setAttribute("orders", orders);
			request.getRequestDispatcher("orderInfo.jsp").forward(request, response);
		}
		if(method.equals("queryAll")){
			List<Orders> orderList = ordersDao.queryAllOrders();
			if(null != orderList && !orderList.isEmpty()){
				request.setAttribute("orderList", orderList);
				request.getRequestDispatcher("orderArrayforEmp.jsp").forward(request, response);
			}
		}
		if(method.equals("queryPersonalOrders")){
			String userId = request.getParameter("userId");
			List<Orders> orderList = ordersDao.queryPersonalOrders(userId);
			if(null != orderList && !orderList.isEmpty()){
				request.setAttribute("orderList", orderList);
				request.getRequestDispatcher("orderList.jsp").forward(request, response);
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
