package wx.sunl.dao;

import java.util.List;

import wx.sunl.model.Employee;
import wx.sunl.model.EmployeeAccount;

public interface EmployeeDao {
	
	public Employee findById(String empId);
	
	public EmployeeAccount login(String account, String passwd);
	
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
