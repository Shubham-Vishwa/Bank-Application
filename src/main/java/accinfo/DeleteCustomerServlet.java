package accinfo;

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
@WebServlet("/delcust")
public class DeleteCustomerServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		if(session==null) {
			pw.print("<script>window.alert('Session Expired...')</script>");
		}else {
			int k = new DeleteCustomerDAO().delete(request);
			if(k>0) {
				pw.print("<script>window.alert('Customer Deleted..')</script>");
			}else {
				pw.print("<script>window.alert('Some Error Occured...')</script>");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

}
