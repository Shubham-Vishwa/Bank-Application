package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.DBConn;

public class GenStatementDAO {
	private Vector<StatementBean> v = new Vector<StatementBean>();
	public Vector<StatementBean> state(String accno) {
		Connection con = DBConn.conn();
		try {
			PreparedStatement ps = con.prepareStatement("select * from statement where accno=?");
			ps.setString(1, accno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StatementBean b = new StatementBean();
				b.setAccno(rs.getString(2));
				b.setRefno(rs.getString(3));
				b.setTransdate(rs.getString(4));
				b.setTransdesc(rs.getString(5));
				b.setDebit(rs.getInt(6));//
				b.setCredit(rs.getInt(7));
				b.setNetBal(rs.getInt(8));
				v.add(b);
			}
		}catch(SQLException e) {e.printStackTrace();}
		return v;
	}
}
