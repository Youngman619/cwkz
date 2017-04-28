package wx.sunl.dao;

import java.util.List;

import wx.sunl.bean.Orders;

public interface OrdersDao {
	
	public Orders findById(String orderId);
	
	public List<Orders> queryAllOrders();
	
	public boolean saveOrUpdate(Orders orders, String order);
	
	public boolean deleteById(String orderId);
	
	public boolean deleteAll();
}
