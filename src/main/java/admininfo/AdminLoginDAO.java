package admininfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import db.DBConn;
public class AdminLoginDAO {
	private AdminBean bean=null;
	public AdminBean login(HttpServletRequest req) {
		try {
			Connection con = DBConn.conn();
			PreparedStatement ps = con.prepareStatement("select * from admininfo where adminid=?");
			ps.setString(1, req.getParameter("id"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass").equals(req.getParameter("pass"))) {
					bean = new AdminBean();
					bean.setAdminId(rs.getString("adminid"));
					bean.setfName(rs.getString("fname"));
					bean.setlName(rs.getString("lname"));
					bean.setPass(rs.getString("pass"));
					bean.setMid(rs.getString("mid"));
					bean.setPhno(rs.getLong("phno"));
				}
			}
		}catch(SQLException e) {e.printStackTrace();}
		return bean;
	}
}
