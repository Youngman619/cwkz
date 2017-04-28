package wx.sunl.dao;

import java.util.List;

import wx.sunl.bean.Info;

public interface InfoDao {
	
	public Info findById(String infoId);
	
	public List<Info> queryAllInfo();
	
	public boolean saveOrUpdate(Info info, String order);
	
	public boolean deleteById(String infoId);
	
	public boolean deleteAll();
}
