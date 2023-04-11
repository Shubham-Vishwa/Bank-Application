package temptable;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/userbiodata")
public class UserBiodataServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		UserBiodataBean bean = new UserBiodataBean();
		bean.setId(req.getParameter("id"));
		bean.setfName(req.getParameter("fname"));
		bean.setlName(req.getParameter("lname"));
		bean.setDob(req.getParameter("dob"));
		bean.setNominee(req.getParameter("nominee"));
		bean.setNomrel(req.getParameter("nomrel"));
		bean.setOccupation(req.getParameter("occupation"));
		bean.setIncome(req.getParameter("income"));
		bean.setAddress(req.getParameter("add"));
		bean.setCity(req.getParameter("city"));
		bean.setDistrict(req.getParameter("district"));
		bean.setState(req.getParameter("state"));
		bean.setPin(req.getParameter("pin"));
		bean.setMid(req.getParameter("mid"));
		bean.setPhno(req.getParameter("phno"));
		bean.setAcctype(req.getParameter("acctype"));
		bean.setBranchCode(req.getParameter("brcode"));
		
		int k = new UserBiodataDAO().submit(bean);
		pw.print(k);
		if(k>0) {
			pw.print("<h2 style='text-align:center;'>Form has been submitted to the bank</h2>");
		}else {
			pw.print("<script>Some Error Occured</script>");
		}
		RequestDispatcher rd = req.getRequestDispatcher("customer.jsp");
		rd.include(req, res);
	}

}
