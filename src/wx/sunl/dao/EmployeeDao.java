package wx.sunl.dao;

import java.util.List;

import wx.sunl.model.Employee;

public interface EmployeeDao {
	
	public Employee findById(String empId);
	
	public Employee login(String account, String passwd);
	
	public List<Employee> queryAllEmployee();
	
	/**
	 * @param emp
	 * @param order(�������޸�ָ��)
	 * @return
	 */
	public boolean saveOrUpdate(Employee emp, String order);
	
	public boolean deleteById(String empId);
	
	public boolean deleteAllEmployee();
}
