package wx.sunl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wx.sunl.bean.Advice;
import wx.sunl.dao.AdviceDao;
import wx.sunl.dao.DBHelper;

public class AdviceDaoImpl implements AdviceDao {
	
	static DBHelper dbh = null;
	
	@Override
	public boolean save(Advice advice) {
		boolean flag = false;
		String sql = null;
		String[] params = null;
		dbh = new DBHelper();
		sql = "INSERT INTO tb_advice VALUES(?,?,?,?,?,?,?,?,?)";
		params = new String[9];
		params[0] = advice.getAdviceId();
		params[1] = advice.getImgUrl01();
		params[2] = advice.getImgUrl02();
		params[3] = advice.getImgUrl03();
		params[4] = advice.getImgUrl04();
		params[5] = advice.getAdviceContent();
		params[6] = advice.getUserId();
		params[7] = advice.getUserName();
		params[8] = String.valueOf(advice.getCreateTime());
		flag = dbh.excuteSql(sql, params);
		return flag;
	}

	@Override
	public boolean update(Advice advice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Advice> queryAllAdvice() {
		Advice advice = null;
		ResultSet rst = null;
		List<Advice> adviceList = new ArrayList<Advice>();
		String sql = "SELECT * FROM tb_advice";
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, null);
		try {
			while(rst.next()){
				advice = new Advice();
				advice.setAdviceId(rst.getString("ADVICE_ID"));
				advice.setImgUrl01(rst.getString("ADVICE_IMG_URL_01"));
				advice.setImgUrl02(rst.getString("ADVICE_IMG_URL_02"));
				advice.setImgUrl03(rst.getString("ADVICE_IMG_URL_03"));
				advice.setImgUrl04(rst.getString("ADVICE_IMG_URL_04"));
				advice.setAdviceContent(rst.getString("ADVICE_CONTENT"));
				advice.setUserId(rst.getString("USER_ID"));
				advice.setUserName(rst.getString("USER_NAME"));
				advice.setCreateTime(rst.getTimestamp("CREATE_TIME"));
				adviceList.add(advice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adviceList;
		
	}

}
