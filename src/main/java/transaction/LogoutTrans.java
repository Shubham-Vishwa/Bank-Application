package transaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/translogout")
public class LogoutTrans extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession(false);
		if(hs==null) {
			pw.print("<script>window.alert('Session already expired...')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}else {
			TransBean b = (TransBean)hs.getAttribute("transbean");
			b.setLastlogin(request.getParameter("outdate"));
//			pw.print(b.getLastlogin()+"ASDF<br/>");
			int k = new LogoutTransDAO().logout(b);
			if(k>0) {
				hs.removeAttribute("transbean");
				hs.invalidate();
				pw.print("<script>window.alert('Logged out successfull...')</script>");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}else {
				pw.print("Some error occured...");
				RequestDispatcher rd = request.getRequestDispatcher("transaction.html");
				rd.include(request, response);
			}
		}
	}
}
