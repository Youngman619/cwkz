package wx.sunl.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import wx.sunl.dao.DBHelper;
import wx.sunl.dao.EmployeeDao;
import wx.sunl.model.Employee;
import wx.sunl.model.EmployeeAccount;

public class EmployeeDaoImpl implements EmployeeDao {
	static DBHelper dbh = null;

	@Override
	public Employee findById(String empId) {
		// TODO Auto-generated method stub
		return null;
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
