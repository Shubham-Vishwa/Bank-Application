package userinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConn;

public class UserRegistrationDAO {
	private int k;
	public int reg(UserBean b) {
		try {
			Connection con = DBConn.conn();
			PreparedStatement ps = con.prepareStatement("insert into userinfo values(?,?,?,?,?)");
			ps.setString(1, b.getfName());
			ps.setString(2, b.getlName());
			ps.setString(3, b.getPass());
			ps.setString(4, b.getMid());
			ps.setLong(5, b.getPhno());
			k = ps.executeUpdate();
		}
		catch(SQLException e) {e.getNextException();}
		return k;
	}
}
