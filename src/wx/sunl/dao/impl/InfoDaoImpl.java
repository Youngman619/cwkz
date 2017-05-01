package wx.sunl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wx.sunl.bean.Info;
import wx.sunl.dao.DBHelper;
import wx.sunl.dao.InfoDao;

public class InfoDaoImpl implements InfoDao {
	
	static DBHelper dbh = null;
	
	@Override
	public Info findById(String infoId) {
		Info info = null;
		ResultSet rst = null;
		String[] params = new String[1];
		String sql = "SELECT * FROM tb_info WHERE INFO_ID = ?";
		params[0] = infoId;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
		try {
			while(rst.next()){
				info = new Info();
				info.setInfoId(rst.getString("INFO_ID"));
				info.setInfoTittle(rst.getString("INFO_TITTLE"));
				info.setInfoContent(rst.getString("INFO_TEXT"));
				info.setEmpNo(rst.getString("EMP_NO"));
				info.setEmpId(rst.getString("EMP_ID"));
				info.setPutTime(rst.getTimestamp("PUT_OUT_TIME"));
				info.setRemark(rst.getString("REMARK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public List<Info> queryAllInfo() {
		Info info = null;
		List<Info> infoList = new ArrayList<Info>();
		String sql = "SELECT * FROM tb_info";
		ResultSet rst = null;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, null);
		try {
			while(rst.next()){
				info = new Info();
				info.setInfoId(rst.getString("INFO_ID"));
				info.setInfoTittle(rst.getString("INFO_TITTLE"));
				info.setInfoContent(rst.getString("INFO_TEXT"));
				info.setEmpNo(rst.getString("EMP_NO"));
				info.setEmpId(rst.getString("EMP_ID"));
				info.setPutTime(rst.getTimestamp("PUT_OUT_TIME"));
				info.setRemark(rst.getString("REMARK"));
				infoList.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return infoList;
	}

	@Override
	public boolean saveOrUpdate(Info info, String order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(String infoId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

}
