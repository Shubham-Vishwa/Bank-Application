package admininfo;

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
@WebServlet("/adminlogin")
public class AdminLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		AdminBean bean = new AdminLoginDAO().login(request);
		pw.print(bean);
		if(bean==null) {
			pw.print("<script>window.alert('Invalid id or password')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}else {
			pw.print("<h2 style='text-align:center;'> Welcome "+bean.getfName()+" "+bean.getlName()+"</h2>");
			HttpSession hs = request.getSession();
			hs.setAttribute("admin", bean);
			RequestDispatcher rd = request.getRequestDispatcher("admin.html");
			rd.forward(request, response);
		}
	}

}
