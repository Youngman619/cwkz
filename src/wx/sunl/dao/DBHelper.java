package wx.sunl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import wx.sunl.util.JDBCUtil;

public class DBHelper {
	private Connection conn;
	private PreparedStatement pst = null;
	private ResultSet rst = null;
	
	public void getConnection(){
		this.conn = JDBCUtil.getConnection();
	}
	
	/**
	 * 实现数据层增加，删除，修改的公共方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean excuteSql(String sql, String[] params){
		this.getConnection();
		boolean res = true;
		try {
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			res = false;
		}finally {
			try {
				JDBCUtil.close(pst, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	/**
	 * 实现数据层查询的公共方法
	 * @param sql
	 * @param params
	 * @param obj
	 * @return
	 */
	public ResultSet excuteQuery(String sql, String[] params){
		this.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			if(null != params){
				for (int i = 0; i < params.length; i++) {
					pst.setString(i+1, params[i]);
				}
			}
			rst = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}
}
