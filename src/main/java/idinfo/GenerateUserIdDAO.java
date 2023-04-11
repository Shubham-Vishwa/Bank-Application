package idinfo;
import java.sql.*;

import db.DBConn;
public class GenerateUserIdDAO {
	private String userid;
	public String getId() {
		try {
			Connection con = DBConn.conn();
			PreparedStatement ps = con.prepareStatement
					("select * from idinfo",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				rs.last();
				return (Integer.parseInt(rs.getString(1))+1)+"";
			}else {
				return "1001";
			}
		}catch(SQLException e) {e.printStackTrace();}
		return userid;
	}
}
