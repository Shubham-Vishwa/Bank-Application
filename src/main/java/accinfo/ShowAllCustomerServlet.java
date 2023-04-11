package accinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/showallcust")
public class ShowAllCustomerServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession(false);
		if(hs==null) {
			pw.print("<script>window.alert('Session expired...')</script>");
		}else {
			Vector<UserDetailsBean> v = new ShowAllCustomerDAO().show();
			if(v==null) {
				pw.print("<script>window.alert('No record Found...')</script>");
			}else {
//				request.setAttribute("details", v);
//				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
//				rd.forward(request, response);
				pw.print("<div style='width:1500px; display:grid; margin:auto; grid-template-columns:50px 100px 75px 75px 75px 75px 150px 100px 100px 75px 75px 75px 200px 150px 75px; background:red; padding:10px;'>"
						+ "<label>User id</label><label>Acc No</label><label>Brcode</label>"+
						"<label>Acc Type</label><label>Status</label><label>Risk</label>"
						+ "<label>Name</label><label>DOB</label><label>Nominee</label>"
						+ "<label>Nominee Rel</label><label>Occupation</label><label>Income</label>"+
						"<label>Full address</label><label>Mail Id</label><label>Phno</label></div>");
				v.forEach((z)->{
					pw.print(z);
				});
			}
		}
		
	}

}
