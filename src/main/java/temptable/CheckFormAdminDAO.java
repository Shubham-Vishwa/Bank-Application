package temptable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConn;

public class CheckFormAdminDAO {
	private UserBiodataBean bean = null;
	public UserBiodataBean showapp() {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps1 = con.prepareStatement("select * from temp");
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				bean = new UserBiodataBean();
				bean.setId(rs.getString(1));
				bean.setfName(rs.getString(2));
				bean.setlName(rs.getString(3));
				bean.setDob(rs.getString(4));
				bean.setNominee(rs.getString(5));
				bean.setNomrel(rs.getString(6));
				bean.setOccupation(rs.getString(7));
				bean.setIncome(rs.getString(8));
				bean.setAddress(rs.getString(9));
				bean.setCity(rs.getString(10));
				bean.setDistrict(rs.getString(11));
				bean.setState(rs.getString(12));
				bean.setPin(rs.getString(13));
				bean.setMid(rs.getString(14));
				bean.setPhno(rs.getString(15));
				bean.setAcctype(rs.getString(16));
				bean.setBranchCode(rs.getString(17));
			}
		}
		catch(SQLException e) {e.printStackTrace();}
		return bean;
	}
}
