package wx.sunl.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import wx.sunl.bean.Room;
import wx.sunl.dao.DBHelper;
import wx.sunl.dao.RoomDao;
import wx.sunl.util.CreateUUID;

public class RoomDaoImpl implements RoomDao {
	static DBHelper dbh = null;
	
	@Override
	public Room findById(String roomId) {
		Room room = null;
		ResultSet rst = null;
		String[] params = new String[1];
		String sql = "SELECT * FROM tb_room WHERE ROOM_ID = ?";
		params[0] = roomId;
		dbh = new DBHelper();
		rst = dbh.excuteQuery(sql, params);
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
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
		boolean flag = false;
		String sql = null;
		String[] params = null;
		if(order.equals("save")){
			sql = "INSERT INTO tb_room VALUES(?,?,?,?,?,?,?,?,?)";
			params = new String[9];
			params[0] = CreateUUID.getUUID();
			params[1] = room.getRoomNo();
			params[2] = room.getRoomType();
			params[3] = room.getRoomFloor();
			params[4] = room.getRoomPosition();
			params[5] = room.getIsWifi();
			params[6] = room.getIsNet();
			params[7] = String.valueOf(room.getRoomArea());
			params[8] = room.getRemark();
		}
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
