package accinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import db.DBConn;

public class EditCustomerDAO {
	private int k=0;
	public int edit(HttpServletRequest req) {
		try {
			Connection con = DBConn.conn();
			PreparedStatement ps = con.prepareStatement("update accinfo set mid=?, phno=? where accno=?");
			ps.setString(1, req.getParameter("mid"));
			ps.setString(2, req.getParameter("phno"));
			ps.setString(3, req.getParameter("accno"));
			k = ps.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();}
		return k;
	}
}
