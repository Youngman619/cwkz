package wx.sunl.dao;

import java.util.List;

import wx.sunl.model.User;

public interface UserDao {
	
	public User findById(String userId);
	
	public User Login(String account, String passwd);
	
	public List<User> queryAllUesr();
	
	/**
	 * @param user
	 * @param order(新增或修改指令)
	 * @return
	 */
	public boolean saveOrUpdate(User user, String order);
	
	public boolean deleteById(String userId);
	
	public boolean deleteAllUser();
}
