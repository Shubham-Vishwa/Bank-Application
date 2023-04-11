package accinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/actinact")
public class ActInactCustServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int k = new ActInactDAO().actinact(request);
		if(k>0) {
			pw.print("<h2>Status of customer changed to "+request.getParameter("status")+"</h2>");
		}else {
			pw.print("<script>window.alert('Invalid account number...')</script>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("admin.html");
		rd.include(request, response);
	}

}
