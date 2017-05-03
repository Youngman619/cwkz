package wx.sunl.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import wx.sunl.bean.Employee;
import wx.sunl.bean.EmployeeAccount;
import wx.sunl.dao.DBHelper;
import wx.sunl.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {
	static DBHelper dbh = null;

	@Override
	public Employee findById(String empId) {
		Employee employee = new Employee();
		ResultSet rst = null;
		String[] params = new String[1];
		String sql = "SELECT * FROM tb_emp WHERE EMP_ID = ?";
		params[0] = empId;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
		try {
			while(rst.next()){
				employee.setEmpId(rst.getString("EMP_ID"));
				employee.setEmpNo(rst.getString("EMP_NO"));
				employee.setEmpName(rst.getString("EMP_NAME"));
				employee.setEmpDepNo(rst.getString("EMP_DEP_NO"));
				employee.setEmpJobNo(rst.getString("EMP_JOB_NO"));
				employee.setInDate(rst.getTimestamp("IN_DATE"));
				employee.setEmpIDCard(rst.getString("EMP_ID_CARD"));
				employee.setEmpPhoneNumber1(rst.getString("EMP_PHONE_ONE"));
				employee.setEmpPhoneNumber2(rst.getString("EMP_PHONE_TWO"));
				employee.setEmpAddr(rst.getString("EMP_ADDR"));
				employee.setRemark(rst.getString("REMARK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public EmployeeAccount login(String account, String passwd) {
		EmployeeAccount employeeAccount = new EmployeeAccount();
		ResultSet rst = null;
		String[] params = new String[2];
		String sql = "SELECT * FROM tb_emp_account WHERE ACCOUNT = ? AND PASSWD = ?";
		params[0] = account;
		params[1] = passwd;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
		try {
			while(rst.next()){
				employeeAccount.setEmpAccountId(rst.getString("EMP_ACCOUNT_ID"));
				employeeAccount.setAccount(rst.getString("ACCOUNT"));
				employeeAccount.setPasswd(rst.getString("PASSWD"));
				employeeAccount.setLevel(rst.getString("LEVEL"));
				employeeAccount.setEmpId(rst.getString("EMP_ID"));
				employeeAccount.setAccountStatus(rst.getString("ACCOUNT_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeAccount;
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
