package userinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import db.DBConn;

public class ForgetPassDAO {
	private int k;
	public int update(HttpServletRequest req) {
		try {
			Connection con = DBConn.conn();
			PreparedStatement ps1 = con.prepareStatement("select phno from userinfo where mid=?");
			PreparedStatement ps2 = con.prepareStatement("update userinfo set pass=? where mid=?");
			ps1.setString(1, req.getParameter("mid"));
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				if(rs.getLong(1)==Long.parseLong(req.getParameter("phno"))) {
					ps2.setString(1, req.getParameter("pass1"));
					ps2.setString(2, req.getParameter("mid"));
					k = ps2.executeUpdate();
				}
			}
		}
		catch(SQLException e) {e.printStackTrace();}
		return k;
	}
}
