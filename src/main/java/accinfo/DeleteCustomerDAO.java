package accinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import db.DBConn;

public class DeleteCustomerDAO {
	private int k=0;
	public int delete(HttpServletRequest req) {
		try {
			Connection con = DBConn.conn();
			PreparedStatement ps = con.prepareStatement("delete from userinfo where accno=?");
			ps.setString(1, req.getParameter("accno"));
			k = ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		return k;
	}
}
