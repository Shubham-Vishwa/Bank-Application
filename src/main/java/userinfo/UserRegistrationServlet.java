package userinfo;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/userreg")
public class UserRegistrationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
//		if(req.getParameter("pass").equals(req.getParameter("pass1"))) {
			UserBean bean = new UserBean();
			bean.setfName(req.getParameter("fname"));
			bean.setlName(req.getParameter("lname"));
			bean.setPass(req.getParameter("pass"));
			bean.setMid(req.getParameter("mid"));
			bean.setPhno(Long.parseLong(req.getParameter("phno")));
			int k = new UserRegistrationDAO().reg(bean);
			if(k>0) {
				pw.print("<h2 style='text-align:center;'>"+bean.getfName()+" "+bean.getlName()+" registered successfully</h2>");
			}else {
				pw.print("<script>window.alert('User not registered...')</script>");
			}
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
//		}else {
//			pw.print("<script>window.alert('Password entered is mismatched')</script>");
//		}
	}

}
