package accinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import db.DBConn;

public class DecideFormAdminDAO {
	private int k = 0;
	public int accept(UserDetailsBean bean) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps1 = con.prepareStatement("insert into accinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			PreparedStatement ps2 = con.prepareStatement("update idinfo set final_decision=?,admin_name=?,remark=? where userid=?");
			PreparedStatement ps3 = con.prepareStatement("delete from temp where id=?");
			
			con.setAutoCommit(false);
			Savepoint sp = con.setSavepoint();
			
			ps1.setString(1, bean.getUserid());
			ps1.setString(2, bean.getAccno());
			ps1.setString(3, bean.getBrcode());
			ps1.setString(4, bean.getAcctype());
			ps1.setString(5, bean.getStatus());
			ps1.setString(6, bean.getRisk());
			ps1.setString(7, bean.getName());
			ps1.setString(8, bean.getDob());
			ps1.setString(9, bean.getNominee());
			ps1.setString(10, bean.getNomrel());
			ps1.setString(11, bean.getOccupation());
			ps1.setInt(12, bean.getIncome());
			ps1.setString(13, bean.getFulladd());
			ps1.setString(14, bean.getMid());
			ps1.setString(15, bean.getPhno());
			int a = ps1.executeUpdate();
			
			if(a>0) {
				ps2.setString(1, "Accepted");
				ps2.setString(2, bean.getAdminName());
				ps2.setString(3, bean.getRemark());
				ps2.setString(4, bean.getUserid());
				int b = ps2.executeUpdate();
				if(b>0) {
					ps3.setString(1, bean.getUserid());
					int c = ps3.executeUpdate();
					if(c>0) {
						k=1;
						con.commit();
					}else con.rollback(sp);
				}else con.rollback(sp);
			}else con.rollback(sp);
		}catch(SQLException e) {e.printStackTrace();}
		return k;
	}
	
	public int reject(UserDetailsBean bean) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps1 = con.prepareStatement("update idinfo set final_decision=?,admin_name=?,remark=? where userid=?");
			PreparedStatement ps2 = con.prepareStatement("delete from temp where id=?");
			
			con.setAutoCommit(false);
			Savepoint sp = con.setSavepoint();
			
			ps1.setString(1, "Rejected");
			ps1.setString(2, bean.getAdminName());
			ps1.setString(3, bean.getRemark());
			ps1.setString(4, bean.getUserid());
			int a = ps1.executeUpdate();
			if(a>0) {
				ps2.setString(1, bean.getUserid());
				int b = ps2.executeUpdate();
				if(b>0) {
					k=1;
					con.commit();
				}else con.rollback(sp);
			}else con.rollback(sp);
		}catch(SQLException e) {e.getNextException();}
		return k;
	}
}
