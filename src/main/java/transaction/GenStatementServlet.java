package transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/genstate")
public class GenStatementServlet extends HttpServlet {

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
			Vector<StatementBean> v = new GenStatementDAO().state(b.getAccno());
			if(v==null) {
				pw.print("<script>window.alert('Invalid account number...')</script>");
			}else {
				pw.print("<div style='width:800px; display:grid; margin:auto; grid-template-columns:100px 100px 175px 200px 75px 75px 75px; background:red; padding:10px;'>"
				+ "<label>Accno</label><label>Transaction Id</label><label>Trans-date</label>"+
				"<label>Trans-desc</label><label>Debit</label><label>Credit</label>"
				+ "<label>Netbal</label></div>");
				v.forEach((z)->{
					pw.print(z);
				});
			}
		}
	}

}
