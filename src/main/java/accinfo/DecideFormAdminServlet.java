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
@WebServlet("/decideformadmin")
public class DecideFormAdminServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
//		UserBiodataBean ubean = (UserBiodataBean)userhs.getAttribute("userbean");
//		pw.print(ubean+"<br/>");
		UserDetailsBean bean = new UserDetailsBean();
		
		if(hs==null) {
			pw.print("<script>window.alert('Session Expired...')</script>");
		}else {
			bean.setUserid(req.getParameter("id"));
			//String accNo = ubean.getId()+ubean.getBranchCode()+(int)ubean.getfName().toUpperCase().charAt(0);
			bean.setAccno(req.getParameter("accno"));
			bean.setBrcode(req.getParameter("brcode"));
			bean.setAcctype(req.getParameter("acctype"));
			bean.setStatus(req.getParameter("status"));
			bean.setRisk(req.getParameter("risk"));
			String name = req.getParameter("fname")+" "+req.getParameter("lname");
			bean.setName(name);
			bean.setDob(req.getParameter("dob"));
			bean.setNominee(req.getParameter("nominee"));
			bean.setNomrel(req.getParameter("nomrel"));
			bean.setOccupation(req.getParameter("occupation"));
			bean.setIncome(Integer.parseInt(req.getParameter("income")));
			String address = req.getParameter("add")+", "+req.getParameter("city")+", "+req.getParameter("district")+
							", "+req.getParameter("state")+", "+req.getParameter("pin");
			bean.setFulladd(address);
			bean.setMid(req.getParameter("mid"));
			bean.setPhno(req.getParameter("phno"));
			bean.setAdminName(req.getParameter("admin"));
			bean.setRemark(req.getParameter("remark"));
		}
		int k=0;
		if(req.getParameter("action").equals("Accept")) {
			k = new DecideFormAdminDAO().accept(bean);
			if(k>0) {
				pw.print("<script>window.alert('Form Accept, Action performed successfully')</script>");
			}else {
				pw.print("<script>window.alert('Some Error Occured...')</script>");
			}
		}else {
			k = new DecideFormAdminDAO().reject(bean);
			if(k>0) {
				pw.print("<script>window.alert('From Rejected, Action performed successfully')</script>");
			}else {
				pw.print("<script>window.alert('Some Error Occured...')</script>");
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("admin.html");
		rd.include(req, res);
	}

}
