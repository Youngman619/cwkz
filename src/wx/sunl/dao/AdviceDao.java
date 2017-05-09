package wx.sunl.dao;

import java.util.List;

import wx.sunl.bean.Advice;

public interface AdviceDao {
	public boolean save(Advice advice);
	
	public boolean update(Advice advice);
	
	public List<Advice> queryAllAdvice();
}
