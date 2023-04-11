package accinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/userdetails")
public class UserDetailsServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		UserDetailsBean bean = new UserDetailsDAO().getDetails(request);
		if(bean==null) {
			pw.print("<h1 style='text-align:center; background:#f0f0f0; padding:100px;'>Data not found....</h1>");
		}else {
			pw.print(bean.display());
		}
	}

}
