package accinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import db.DBConn;

public class UserDetailsDAO {
	private UserDetailsBean bean;
	public UserDetailsBean getDetails(HttpServletRequest req) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps = con.prepareStatement("select * from accinfo where accno=? and dob=?");
			ps.setString(1, req.getParameter("accno"));
			ps.setString(2, req.getParameter("dob"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bean = new UserDetailsBean();
				bean.setUserid(rs.getString(1));
				bean.setAccno(rs.getString(2));
				bean.setBrcode(rs.getString(3));
				bean.setAcctype(rs.getString(4));
				bean.setStatus(rs.getString(5));
				bean.setRisk(rs.getString(6));
				bean.setName(rs.getString(7));
				bean.setDob(rs.getString(8));
				bean.setNominee(rs.getString(9));
				bean.setNomrel(rs.getString(10));
				bean.setOccupation(rs.getString(11));
				bean.setIncome(rs.getInt(12));
				bean.setFulladd(rs.getString(13));
				bean.setMid(rs.getString(14));
				bean.setPhno(rs.getString(15));
			}
		}catch(SQLException e) {e.printStackTrace();}
		return bean;
	}
}
