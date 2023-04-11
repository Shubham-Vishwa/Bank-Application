package accinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.DBConn;

public class ShowAllCustomerDAO {
	private Vector<UserDetailsBean> v = new Vector<>();
	public Vector<UserDetailsBean> show(){
		try {
			Connection con = DBConn.conn();
			PreparedStatement ps = con.prepareStatement("select * from accinfo");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UserDetailsBean bean = new UserDetailsBean();
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
				v.add(bean);
			}
		}catch(SQLException e) {e.printStackTrace();}
		return v;
	}
}
