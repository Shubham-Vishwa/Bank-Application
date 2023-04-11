package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import db.DBConn;

public class TransLoginDAO {
	private TransBean bean= null;
	public TransBean login(HttpServletRequest req) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps1 = con.prepareStatement("select * from atminfo where accno=? and pin=?");
			PreparedStatement ps2 = con.prepareStatement("select lastlogin from logininfo where userid=?");
			PreparedStatement ps3 = con.prepareStatement("select netbal from statement where "
					+ "transdate=(select max(transdate) from statement where accno=?)");
			ps1.setString(1, req.getParameter("accno"));
			ps1.setString(2, req.getParameter("pin"));
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) {
				ps2.setString(1, req.getParameter("accno"));
				ResultSet rs2 = ps2.executeQuery();
				ps3.setString(1, req.getParameter("accno"));
				ResultSet rs3 = ps3.executeQuery();
				if(rs2.next() && rs3.next()) {
					bean = new TransBean();
					bean.setAccno(rs1.getString(1));
					bean.setName(rs1.getString(2));
					bean.setMid(rs1.getString(4));
					bean.setPhno(rs1.getString(5));
					bean.setLastlogin(rs2.getString("lastlogin"));
					bean.setTotbal(rs3.getInt("netbal"));
				}
			}
		}catch(Exception e) {e.printStackTrace();}
		return bean;
	}
}
