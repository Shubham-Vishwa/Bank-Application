package atminfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConn;

public class ShowAtmDAO {
	private ATMBean b = null;
	public ATMBean show(String accno) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps = con.prepareStatement("select * from atminfo where accno=?");
			ps.setString(1, accno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b = new ATMBean();
				b.setAccNo(rs.getString(1));
				b.setName(rs.getString(2));
				b.setCardno(rs.getString(3));
				b.setCvv(rs.getString(4));
				b.setPin(rs.getString(5));
				b.setCardtype(rs.getString(6));
				b.setMid(rs.getString(7));
				b.setPhno(rs.getString(8));
			}
		}catch(SQLException e) {e.printStackTrace();}
		return b;
	}
}
