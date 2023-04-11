package userinfo;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forgetpass")
@SuppressWarnings("serial")
public class ForgetPassServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		RequestDispatcher rd = null;
		if(req.getParameter("pass1").equals(req.getParameter("pass2"))) {
			int k = new ForgetPassDAO().update(req);
			if(k>0) {
				pw.print("<script>window.alert('Password updated successfully')</script>");
				rd = req.getRequestDispatcher("customer.jsp");
			}else {
				pw.print("<script>window.alert('OOPs something went wrong')</script>");
				rd = req.getRequestDispatcher("customer.jsp");
			}
		}else {
			pw.print("<script>window.alert('Password mismatched')</script>");
			rd = req.getRequestDispatcher("customer.jsp");
		}
		rd.include(req, res);
	}
}
