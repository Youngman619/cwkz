package wx.sunl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wx.sunl.bean.Orders;
import wx.sunl.dao.DBHelper;
import wx.sunl.dao.OrdersDao;

public class OrdersDaoImpl implements OrdersDao {
	
	static DBHelper dbh = null;
	
	@Override
	public Orders findById(String orderId) {
		Orders orders = null;
		ResultSet rst = null;
		String[] params = new String[1];
		String sql = "SELECT * FROM tb_order WHERE ORDER_ID = ?";
		params[0] = orderId;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
		try {
			while(rst.next()){
				orders = new Orders();
				orders.setOrderId(rst.getString("ORDER_ID"));
				orders.setOoderNo(rst.getString("ORDER_NO"));
				orders.setCreateTime(rst.getTimestamp("CREATE_TIME"));
				orders.setRoomNo(rst.getString("ROOM_NO"));
				orders.setRoomId(rst.getString("ROOM_ID"));
				orders.setOrderStatus(rst.getString("ORDER_STATUS"));
				orders.setHandleTime(rst.getTimestamp("HANDLE_TIME"));
				orders.setEmpNo(rst.getString("EMP_NO"));
				orders.setEmpId(rst.getString("EMP_ID"));
				orders.setRemark(rst.getString("REMARK"));
				orders.setUserId(rst.getString("USER_ID"));
				orders.setPlanInTime(rst.getTimestamp("PLAN_IN_TIME"));
				orders.setPlanInDays(rst.getString("PLAN_IN_DAYS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<Orders> queryAllOrders() {
		Orders orders = null;
		ResultSet rst = null;
		List<Orders> orderList = new ArrayList<Orders>();
		String sql = "SELECT * FROM tb_order";
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, null);
		try {
			while(rst.next()){
				orders = new Orders();
				orders.setOrderId(rst.getString("ORDER_ID"));
				orders.setOoderNo(rst.getString("ORDER_NO"));
				orders.setCreateTime(rst.getTimestamp("CREATE_TIME"));
				orders.setRoomNo(rst.getString("ROOM_NO"));
				orders.setRoomId(rst.getString("ROOM_ID"));
				orders.setOrderStatus(rst.getString("ORDER_STATUS"));
				orders.setHandleTime(rst.getTimestamp("HANDLE_TIME"));
				orders.setEmpNo(rst.getString("EMP_NO"));
				orders.setEmpId(rst.getString("EMP_ID"));
				orders.setRemark(rst.getString("REMARK"));
				orders.setUserId(rst.getString("USER_ID"));
				orders.setPlanInTime(rst.getTimestamp("PLAN_IN_TIME"));
				orders.setPlanInDays(rst.getString("PLAN_IN_DAYS"));
				orderList.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public boolean saveOrUpdate(Orders orders, String order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

}
