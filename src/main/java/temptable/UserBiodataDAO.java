package temptable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import db.DBConn;

public class UserBiodataDAO {
	private int k=0;
	public int submit(UserBiodataBean bean) {
		try {
			Connection con = DBConn.conn();
			PreparedStatement ps = con.prepareStatement("insert into temp values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("insert into idinfo(userid,username) values(?,?)");
			
			con.setAutoCommit(false);
			Savepoint sp = con.setSavepoint();
			
			ps.setString(1, bean.getId());
			ps.setString(2, bean.getfName());
			ps.setString(3, bean.getlName());
			ps.setString(4, bean.getDob());
			ps.setString(5, bean.getNominee());
			ps.setString(6, bean.getNomrel());
			ps.setString(7, bean.getOccupation());
			ps.setString(8, bean.getIncome());
			ps.setString(9, bean.getAddress());
			ps.setString(10, bean.getCity());
			ps.setString(11, bean.getDistrict());
			ps.setString(12, bean.getState());
			ps.setString(13, bean.getPin());
			ps.setString(14, bean.getMid());
			ps.setString(15, bean.getPhno());
			ps.setString(16, bean.getAcctype());
			ps.setString(17, bean.getBranchCode());
			int a = ps.executeUpdate();
			ps2.setString(1, bean.getId());
			ps2.setString(2, bean.getfName()+" "+bean.getlName());
			int b = ps2.executeUpdate();
			if(a==1 && b==1) {
				con.commit();
				k=1;
			}else {
				con.rollback(sp);
			}
		}
		catch(SQLException e) {e.printStackTrace();}
		return k;
	}
}
