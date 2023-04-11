package atminfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import transaction.TransBean;

@SuppressWarnings("serial")
@WebServlet("/showatm")
public class ShowAtmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession(false);
		if(hs==null) {
			pw.print("<script>window.alert('Session expired...')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}else {
			TransBean b = (TransBean)hs.getAttribute("transbean");
			ATMBean ab = new ShowAtmDAO().show(b.getAccno());
			request.setAttribute("atminfo", ab);
			RequestDispatcher rd = request.getRequestDispatcher("ATM.jsp");
			rd.forward(request, response);
		}
	}

}
