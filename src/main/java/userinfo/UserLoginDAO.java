package userinfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import db.DBConn;
public class UserLoginDAO {
	
	private UserBean bean=null;
	public UserBean login(HttpServletRequest req) {
		try {
			Connection con = DBConn.conn();
			PreparedStatement ps = con.prepareStatement("select * from userinfo where mid=?");
			ps.setString(1, req.getParameter("mid"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass").equals(req.getParameter("pass"))) {
					bean = new UserBean();
					bean.setfName(rs.getString(1));
					bean.setlName(rs.getString(2));
					bean.setPass(rs.getString(3));
					bean.setMid(rs.getString(4));
					bean.setPhno(rs.getLong(5));
				}
			}
		}catch(SQLException e) {e.printStackTrace();}
		return bean;
	}
}
