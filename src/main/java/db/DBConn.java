package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConn {
	private static Connection con = null;
	
	private DBConn() {}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/bank","root","Vishwa123");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection conn() {
		return con;
	}
}
