package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConn;

public class TransferMoneyDAO {
	private int k = 0;
	public int transfer(TransferBean b) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps1 = con.prepareStatement("select status from accinfo where accno=?");
			PreparedStatement ps2 = con.prepareStatement("insert into statement(accno,txnid,transdate,transdesc,debit,credit,netbal) "
					+ "values(?,?,?,?,?,?,?)");
			PreparedStatement ps = con.prepareStatement("select netbal from statement where "
					+ "transdate=(select max(transdate) from statement where accno=?)");
			con.setAutoCommit(false);
			con.setSavepoint();
			ps1.setString(1, b.getAccno());
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) {
				if(rs1.getString("status").equals("active")) {
					ps2.setString(1, b.getAccno());
					ps2.setString(2, b.getTxnid());
					ps2.setString(3, b.getTransdate());
					ps2.setString(4, b.getTransdesc1());
					ps2.setInt(5, b.getAmount());
					ps2.setInt(6, 0);
					ps2.setInt(7, b.getTotbal()-b.getAmount());
					int x = ps2.executeUpdate();
					
					int z =-1;
					int amt=0;
					ps.setString(1, b.getBaccno());
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
						amt = rs.getInt("netbal");
						z=1;
					}
					
					ps2.setString(1, b.getBaccno());
					ps2.setString(2, b.getTxnid());
					ps2.setString(3, b.getTransdate());
					ps2.setString(4, b.getTransdesc2());
					ps2.setInt(5, 0);
					ps2.setInt(6, b.getAmount());
					ps2.setInt(7, amt+b.getAmount());
					int y = ps2.executeUpdate();
					if(x>0 && y>0 && z>0) {
						con.commit();
						k=1;
					}else {
						con.rollback();
						k=-1;
					}
				}
			}
		}catch(SQLException e) {e.printStackTrace();}
		return k;
	}
}
