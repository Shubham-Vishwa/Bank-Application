package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConn;

public class LogoutTransDAO {
	private int k=0;
	public int logout(TransBean bean) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps = con.prepareStatement("update logininfo set lastlogin=? where userid=?");
			ps.setString(1, bean.getLastlogin());
			ps.setString(2, bean.getAccno());
			k = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
