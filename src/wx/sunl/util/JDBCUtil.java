package wx.sunl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	private static final String url = "jdbc:mysql://180.76.189.247:3306/cwkz";
	private static final String uname = "root";
	private static final String pwd = "2wsx@WSX";
	
	private static Connection conn = null;
	
	/**
	 * 连接数据库操作
	 * @return
	 */
	public static Connection getConnection(){
		  try
		    {
		      // 1.加载驱动程序
		      Class.forName("com.mysql.jdbc.Driver");
		      // 2.获得数据库的连接
		      conn = DriverManager.getConnection(url, uname, pwd);
		    }
		    catch (ClassNotFoundException e)
		    {
		      e.printStackTrace();
		    }
		    catch (SQLException e)
		    {
		      e.printStackTrace();
		    }
		  	return conn;
	  }
	
	/**
	 * 关闭数据库连接
	 * @param pst
	 * @param conn
	 * @throws SQLException
	 */
	public static void close(PreparedStatement pst, Connection conn)throws SQLException{
		if(pst != null){
			pst.close();
		}
		if(conn != null){
		conn.close();
		}
	}
	
/*	public static void main(String[] args) {
		Connection conn = getConnection();
		System.out.println(conn);
	}*/
}
