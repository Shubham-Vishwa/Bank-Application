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
@WebServlet("/translogin")
public class TransLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		TransBean bean = new TransLoginDAO().login(request);
		if(bean==null) {
			pw.print("<script>window.alert('Invalid Account number of PIN')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}else {
			HttpSession hs = request.getSession();
			hs.setAttribute("transbean", bean);
			pw.print("<div style='background:#f0f0f0; text-align:center; padding:5px;'><h3 style='display:inline'>Welcome </h3><h2 style='display:inline'>"+bean.getName()+"</h2></div>");
			
			
			if(bean.getLastlogin()==null) {
				pw.print("<div style='background:#f0f0f0; text-align:center; padding:5px;'><h3>This is your first login...</h3></div>");
			}else {
				pw.print("<div style='background:#f0f0f0; text-align:center; padding:5px;'><h4 style='display:inline'>Your last login was </h4><h3 style='display:inline'>"+bean.getLastlogin()+"</h3></div>");
			}
			RequestDispatcher rd = request.getRequestDispatcher("transaction.html");
			rd.include(request, response);
		}
	}

}
