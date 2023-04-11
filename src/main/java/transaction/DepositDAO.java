package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBConn;

public class DepositDAO {
	private int k=0;
	public int deposit(StatementBean bean) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps = con.prepareStatement("insert into statement(accno,txnid,transdate,transdesc,debit,credit,netbal) values(?,?,?,?,?,?,?)");
			ps.setString(1, bean.getAccno());
			ps.setString(2, bean.getRefno());
			ps.setString(3, bean.getTransdate());
			ps.setString(4, bean.getTransdesc());
			ps.setInt(5, bean.getDebit());
			ps.setInt(6, bean.getCredit());
			ps.setInt(7, bean.getNetBal());
			k = ps.executeUpdate();
			
		}catch(SQLException e) {e.printStackTrace();}
		return k;
	}
}
