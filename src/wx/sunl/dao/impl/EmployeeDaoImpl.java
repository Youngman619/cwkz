package wx.sunl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import wx.sunl.dao.DBHelper;
import wx.sunl.dao.EmployeeDao;
import wx.sunl.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	static DBHelper dbh = null;

	@Override
	public Employee findById(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee login(String account, String passwd) {
		Employee emp = new Employee();
		ResultSet rst = null;
		String[] params = new String[2];
		String sql = "SELECT * FROM tb_emp_account WHERE ACCOUNT = ? AND PASSWD = ?";
		params[0] = account;
		params[1] = passwd;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
		try {
			while(rst.next()){
				emp.setEmpId(rst.getString("EMP_ID"));
				emp.setEmpNo(rst.getString("EMP_NO"));
				emp.setEmpName(rst.getString("EMP_NAME"));
				emp.setEmpDepNo(rst.getString("EMP_DEP_NO"));
				emp.setEmpJobNo(rst.getString("EMP_JOB_NO"));
				emp.setInDate(rst.getTimestamp("IN_DATE"));
				emp.setEmpIDCard(rst.getString("EMP_ID_CARD"));
				emp.setEmpPhoneNumber1(rst.getString("EMP_PHONE_ONE"));
				emp.setEmpPhoneNumber2(rst.getString("EMP_PHONE_TWO"));
				emp.setEmpAddr(rst.getString("EMP_ADDR"));
				emp.setRemark(rst.getString("REMARK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> queryAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveOrUpdate(Employee emp, String order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(String empId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAllEmployee() {
		// TODO Auto-generated method stub
		return false;
	}

}
