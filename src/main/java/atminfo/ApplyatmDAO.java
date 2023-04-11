package atminfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConn;

public class ApplyatmDAO {
	private int k=0;
	public int apply(ATMBean bean) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps1 = con.prepareStatement("select uname,mid,phno from accinfo where accno=?");
			PreparedStatement ps2 = con.prepareStatement("insert into atminfo values(?,?,?,?,?,?,?,?)");
			PreparedStatement ps3 = con.prepareStatement("insert into logininfo values(?,?,?,?)");
			PreparedStatement ps4 = con.prepareStatement("insert into statement(accno,txnid,transdate,transdesc,debit,credit,netbal) values(?,?,?,?,?,?,?)");
			con.setAutoCommit(false);
			con.setSavepoint();
			ps1.setString(1, bean.getAccNo());
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				String name = rs.getString("uname");
				String mid1 = rs.getString("mid");
				String phno1 = rs.getString("phno");
				if(mid1.equals(bean.getMid()) && phno1.equals(bean.getPhno())) {
					
					ps2.setString(1, bean.getAccNo());
					ps2.setString(2, name);
					ps2.setString(3, bean.getCardno());
					ps2.setString(4, bean.getCvv());
					ps2.setString(5, bean.getPin());
					ps2.setString(6, bean.getCardtype());
					ps2.setString(7, bean.getMid());
					ps2.setString(8, bean.getPhno());
					int a = ps2.executeUpdate();
					
					ps3.setString(1, bean.getAccNo());
					ps3.setString(2, name);
					ps3.setString(3, "customer");
					ps3.setString(4, null);
					int b = ps3.executeUpdate();
					
					ps4.setString(1, bean.getAccNo());
					ps4.setString(2, "Default");
					ps4.setString(3, bean.getAtmreldate());
					ps4.setString(4, "Initial");
					ps4.setInt(5, 0);
					ps4.setInt(6, 0);
					ps4.setInt(7, 500);
					int c = ps4.executeUpdate();
					if(a>0 && b>0 && c>0) {
						con.commit();
						k=1;
					}else {
						k=-1;
						con.rollback();
					}
				}
			}
			
		}catch(SQLException e) {e.printStackTrace();}
		return k;
	}
}
