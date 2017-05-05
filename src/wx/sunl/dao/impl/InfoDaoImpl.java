package wx.sunl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wx.sunl.bean.Info;
import wx.sunl.dao.DBHelper;
import wx.sunl.dao.InfoDao;
import wx.sunl.util.CreateUUID;

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
		boolean flag = false;
		String sql = null;
		String[] params = null;
		dbh = new DBHelper();
		if(order.equals("save")){
			sql = "INSERT INTO tb_info VALUES(?,?,?,?,?,?,?)";
			params = new String[7];
			params[0] = CreateUUID.getUUID();
			params[1] = info.getInfoTittle();
			params[2] = info.getInfoContent();
			params[3] = info.getEmpNo();
			params[4] = info.getEmpId();
			params[5] = String.valueOf(info.getPutTime());
			params[6] = info.getRemark();
			flag = dbh.excuteSql(sql, params);
		}else{
			sql = "UPDATE tb_info SET INFO_TITTLE=?,INFO_TEXT=?,EMP_NO=?,EMP_ID=?,PUT_OUT_TIME=?,REMARK=? WHERE INFO_ID=?";
			params = new String[7];
			params[0] = info.getInfoTittle();
			params[1] = info.getInfoContent();
			params[2] = info.getEmpNo();
			params[3] = info.getEmpId();
			params[4] = String.valueOf(info.getPutTime());
			params[5] = info.getRemark();
			params[6] = info.getInfoId();
			flag = dbh.excuteSql(sql, params);
		}
		return flag;
	}

	@Override
	public boolean deleteById(String infoId) {
		boolean flag = false;
		dbh = new DBHelper();
		String[] params = new String[1];
		String sql = "DELETE FROM tb_info WHERE INFO_ID=?";
		params[0] = infoId;
		flag = dbh.excuteSql(sql, params);
		return flag;
	}

	@Override
	public boolean deleteAll() {
		boolean flag = false;
		dbh = new DBHelper();
		String sql = "DELETE * FROM tb_info";
		flag = dbh.excuteSql(sql, null);
		return flag;
	}

}
