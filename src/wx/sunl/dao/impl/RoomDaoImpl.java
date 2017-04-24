package wx.sunl.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wx.sunl.dao.DBHelper;
import wx.sunl.dao.RoomDao;
import wx.sunl.model.Room;

public class RoomDaoImpl implements RoomDao {

	static DBHelper dbh = null;
	
	@Override
	public Room findById(String roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> queryAllRoom() {
		String sql = "SELECT * FROM tb_room";
		ResultSet rst = null;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, null);
		Room room = null;
		List<Room> roomList = new ArrayList<Room>();
		try {
			while(rst.next()){
				room = new Room();
				room.setRoomId(rst.getString("ROOM_ID"));
				room.setRoomNo(rst.getString("ROOM_NO"));
				room.setRoomType(rst.getString("ROOM_TYPE"));
				room.setRoomFloor(rst.getString("ROOM_FLOOR"));
				room.setRoomPosition(rst.getString("ROOM_POSITION"));
				room.setIsWifi(rst.getString("IS_WIFI"));
				room.setIsNet(rst.getString("IS_NET"));
				room.setRoomArea(rst.getDouble("ROOM_AREA"));
				room.setIsLock(rst.getString("IS_LOCK"));
				room.setRemark(rst.getString("REMARK"));
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomList;
	}

	@Override
	public boolean saveOrUpdate(Room room, String order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(String roomId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

}
