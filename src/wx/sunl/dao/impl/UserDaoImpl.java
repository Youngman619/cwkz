package wx.sunl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wx.sunl.bean.User;
import wx.sunl.bean.UserAccount;
import wx.sunl.dao.DBHelper;
import wx.sunl.dao.UserDao;
import wx.sunl.util.CreateUUID;

public class UserDaoImpl implements UserDao {
	
	static DBHelper dbh = null;
	
	@Override
	public User findById(String userId) {
		User user = null;
		ResultSet rst = null;
		String[] params = new String[1];
		String sql = "SELECT * FROM tb_user WHERE USER_ID = ?";
		params[0] = userId;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
		try {
			while(rst.next()){
				user = new User();
				user.setUserId(rst.getString("USER_ID"));
				user.setUserName(rst.getString("USER_NAME"));
				user.setUserSex(rst.getString("USER_SEX"));
				user.setUserIDCard(rst.getString("USER_ID_CARD"));
				user.setUserPhoneNumber1(rst.getString("USER_PHONE_ONE"));
				user.setUserPhoneNumber2(rst.getString("USER_PHONE_TWO"));
				user.setUserAddr(rst.getString("USER_ADDR"));
				user.setRemark(rst.getString("REMARK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public UserAccount Login(String account, String passwd) {
		UserAccount userAccount = new UserAccount();
		ResultSet rst = null;
		String[] params = new String[2];
		String sql = "SELECT * FROM tb_user_account WHERE ACCOUNT = ? AND PASSWD = ?";
		params[0] = account;
		params[1] = passwd;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
		try {
			while(rst.next()){
				userAccount.setUserAccountId(rst.getString("USER_ACCOUNT_ID"));
				userAccount.setUserId(rst.getString("USER_ID"));
				userAccount.setAccount(rst.getString("ACCOUNT"));
				userAccount.setPasswd(rst.getString("PASSWD"));
				userAccount.setLevel(rst.getString("LEVEL"));
				userAccount.setAccountStatus(rst.getString("ACCOUNT_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userAccount;
	}

	@Override
	public List<User> queryAllUesr() {
		User user = null;
		List<User> userList = new ArrayList<User>();
		ResultSet rst = null;
		String sql = "SELECT * FROM tb_user";
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, null);
		try {
			while(rst.next()){
				user = new User();
				user.setUserId(rst.getString("USER_ID"));
				user.setUserName(rst.getString("USER_NAME"));
				user.setUserSex(rst.getString("USER_SEX"));
				user.setUserIDCard(rst.getString("USER_ID_CARD"));
				user.setUserPhoneNumber1(rst.getString("USER_PHONE_ONE"));
				user.setUserPhoneNumber2(rst.getString("USER_PHONE_TWO"));
				user.setUserAddr(rst.getString("USER_ADDR"));
				user.setRemark(rst.getString("REMARK"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public boolean saveOrUpdate(User user, String order) {
		boolean flag = false;
		String sql = null;
		String[] params = null;
		dbh = new DBHelper();
		if(order.equals("save")){
			sql = "INSERT INTO tb_user VALUES(?,?,?,?,?,?,?,?)";
			params = new String[8];
			params[0] = CreateUUID.getUUID();
			params[1] = user.getUserName();
			params[2] = user.getUserSex();
			params[3] = user.getUserIDCard();
			params[4] = user.getUserPhoneNumber1();
			params[5] = user.getUserPhoneNumber2();
			params[6] = user.getUserAddr();
			params[7] = user.getRemark();
			flag = dbh.excuteSql(sql, params);
		}else{
			sql = "UPDATE tb_user SET USER_NAME=?,USER_SEX=?,USER_ID_CARD=?,USER_PHONE_ONE=?,USER_PHONE_TWO=?,USER_ADDR=?,REMARK=? WHERE USER_ID=?";
			params = new String[8];
			params[0] = user.getUserName();
			params[1] = user.getUserSex();
			params[2] = user.getUserIDCard();
			params[3] = user.getUserPhoneNumber1();
			params[4] = user.getUserPhoneNumber2();
			params[5] = user.getUserAddr();
			params[6] = user.getRemark();
			params[7] = user.getUserId();
			flag = dbh.excuteSql(sql, params);
		}
		return flag;
	}

	@Override
	public boolean deleteById(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAllUser() {
		// TODO Auto-generated method stub
		return false;
	}

}
