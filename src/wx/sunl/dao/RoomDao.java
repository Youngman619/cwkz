package wx.sunl.dao;

import java.util.List;

import wx.sunl.model.Room;

public interface RoomDao {
	
	public Room findById(String roomId);
	
	public List<Room> queryAllRoom();
	
	public boolean saveOrUpdate(Room room, String order);
	
	public boolean deleteById(String roomId);
	
	public boolean deleteAll();
}
