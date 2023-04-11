package transaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession(false);
		TransBean b = (TransBean)hs.getAttribute("transbean");
		pw.print("<div style='text-align:center; padding:100px; background:#f0f0f0;'><h4 style='display:inline'>Available account balance is: &#8377; </h4><h1 style='display:inline'>"+b.getTotbal()+".00</h1></div>");
	}

}
