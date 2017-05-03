package wx.sunl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wx.sunl.bean.Room;
import wx.sunl.dao.RoomDao;
import wx.sunl.dao.Impl.RoomDaoImpl;

/**
 * Servlet implementation class RoomServlet
 */
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(null != method && !method.equals("")){
			if(method.equals("queryAll")){
				List<Room> roomList = this.queryAll();
				request.setAttribute("roomList", roomList);
			}
			if(method.equals("querOne")){
				String roomId = request.getParameter("roomId");
				Room room = this.queryOne(roomId);
				request.setAttribute("room", room);
			}
			if(method.equals("save")){
				
			}
			if(method.equals("update")){
							
			}
			if(method.equals("delete")){
				
			}
		}
		request.getRequestDispatcher("roomList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private List<Room> queryAll(){
		RoomDao roomDao = new RoomDaoImpl();
		List<Room> roomList = roomDao.queryAllRoom();
		return roomList;
	}
	
	private Room queryOne(String roomId){
		RoomDao roomDao = new RoomDaoImpl();
		Room room = roomDao.findById(roomId);
		return room;
	}

}
