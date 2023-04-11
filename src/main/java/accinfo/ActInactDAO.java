package accinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import db.DBConn;

public class ActInactDAO {
	private int k = 0;
	public int actinact(HttpServletRequest req) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps = con.prepareStatement("update accinfo set status=? where accno=?");
			ps.setString(1, req.getParameter("status"));
			ps.setString(2, req.getParameter("accno"));
			k = ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		return k;
	}
}
