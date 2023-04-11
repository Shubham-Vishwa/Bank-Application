package temptable;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admininfo.AdminBean;
@SuppressWarnings("serial")
@WebServlet("/checkformadmin")//html
public class CheckFormAdminServlet extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		AdminBean admin =(AdminBean)hs.getAttribute("admin");
		UserBiodataBean bean = new CheckFormAdminDAO().showapp();
		if(admin==null) {
			pw.print("Session Expired...");
		}else {
			if(bean==null) {
				pw.print("<h2 style='text-align:center; padding:100px; background:#f0f0f0;'>No pending application</h2>");
			}else {
				pw.print("<script>bean is generated</script>");
				req.setAttribute("ubiodata", bean);
//				RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
//				rd.include(req, res);
				String accNo = bean.getId()+bean.getBranchCode()+(int)bean.getfName().toUpperCase().charAt(0);
				
			String html = "<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Open Account</title>\r\n"
					+ "<style>\r\n"
					+ "	#main{\r\n"
					+ "		width:500px;\r\n"
					+ "		margin:10px auto;\r\n"
					+ "		padding:20px;\r\n"
					+ "		box-shadow:3px 3px 10px;\r\n"
					+ "	}\r\n"
					+ "	h4{\r\n"
					+ "		display:inline;\r\n"
					+ "		color:red;\r\n"
					+ "		text-align:center;\r\n"
					+ "	}\r\n"
					+ "	.heading{\r\n"
					+ "		background:#e9e9e9;\r\n"
					+ "		text-align:center;\r\n"
					+ "	}\r\n"
					+ "</style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "<div id=\"main\">\r\n"
					+ "  <div id=\"sub1\"><h2>Account Opening Form</h2></div>\r\n"
					+ "    <div id=\"sub2\">\r\n"
					+ "	  <form action=\"decideformadmin\" method=\"post\">\r\n"
					+ "		<table>\r\n"
					+ "		  <tr><td colspan=2 class=\"heading\"><h4>Personal Details</h4></td></tr>\r\n"
					+ "		  <tr><td>First Name:</td><td><input type=\"text\" name=\"fname\" value="+bean.getfName()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Last Name:</td><td><input type=\"text\" name=\"lname\" value="+bean.getlName()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Date of Birth:</td><td><input type=\"date\" name=\"dob\"  value="+bean.getDob()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Nominee Name:</td><td><input type=\"text\" name=\"nominee\"  value="+bean.getNominee()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Relation with Nominee:</td><td><input type=\"text\" name=\"nomrel\" value="+bean.getNomrel()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td colspan=2 class=\"heading\"><h4>Occupation Details</h4></td></tr>\r\n"
					+ "		  <tr><td>Occupation Type/Service:</td><td>\r\n"
					+ "		  								<input type=\"text\" name=\"occupation\" value="+bean.getOccupation()+" readonly/>\r\n"
					+ "		  								</td></tr>\r\n"
					+ "		  <tr><td>Annual Income:</td><td><input type=\"text\" name=\"income\" value="+bean.getIncome()+" readonly/>Rs.</td></tr>\r\n"
					+ "		  <tr><td colspan=2 class=\"heading\"><h4>Address Details</h4></td></tr>\r\n"
					+ "		  <tr><td>Address:</td><td><input type=\"text\" name=\"add\" value="+bean.getAddress()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>City:</td><td><input type=\"text\" name=\"city\" value="+bean.getCity()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>District:</td><td><input type=\"text\" name=\"district\" value="+bean.getDistrict()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>State:</td><td><input type=\"text\" name=\"state\" value="+bean.getState()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Pin Code:</td><td><input type=\"text\" name=\"pin\" value="+bean.getPin()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td colspan=2 class=\"heading\"><h4>Contact Details</h4></td></tr>\r\n"
					+ "		  <tr><td>Email Id:</td><td><input type=\"text\" name=\"mid\" value="+bean.getMid()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Phone Number:</td><td><input type=\"text\" name=\"phno\" value="+bean.getPhno()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td colspan=2 class=\"heading\"><h4>Bank Details</h4></td></tr>\r\n"
					+ "		  <tr><td>Customer Id:</td><td><input type=\"text\" name=\"id\" value="+bean.getId()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Branch Code:</td><td><input type=\"text\" name=\"brcode\" value="+bean.getBranchCode()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Account Type:</td><td><input type=\"text\" name=\"acctype\" value="+bean.getAcctype()+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Account Number:</td><td><input type=\"text\" name=\"accno\" value="+accNo+" readonly/></td></tr>\r\n"
					+ "		  <tr><td>Current Status:</td><td>\r\n"
					+ "		  							<input type=\"radio\" name=\"status\" value=\"active\"/>\r\n"
					+ "		  							Active\r\n"
					+ "			  						<input type=\"radio\" name=\"status\" value=\"inactive\"/>\r\n"
					+ "		  							Inactive\r\n"
					+ "		  						</td></tr>\r\n"
					+ "		  <tr><td>Risk Category:</td><td>\r\n"
					+ "		  							<select name=\"risk\">\r\n"
					+ "		  								<option value=\"high\">High</option>\r\n"
					+ "		  								<option value=\"medium\">Medium</option>\r\n"
					+ "		  								<option value=\"low\">Low</option>\r\n"
					+ "		  							</select>\r\n"
					+ "		  						</td></tr>\r\n"
					+ "		  <tr><td>Remark:</td><td><input type='text' name='remark'/></td></tr>\r\n"
					+ "		  <tr><td colspan=2><input type='hidden' name='admin' value="+admin.getfName()+" "+admin.getlName()+"</td></tr>\r\n"
					+ "		  <tr><td></td><td>\r\n"
					+ "		  				<input type=\"submit\" value=\"Accept\" name=\"action\"/>\r\n"
					+ "						<input type=\"submit\" value=\"Reject\" name=\"action\"/>\r\n"
					+ "		  			</td></tr>\r\n"
					+ "		</table><br/><br/>\r\n"
					+ "	 </form>\r\n"
					+ "  </div>\r\n"
					+ "</div>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n";
			pw.print(html);
			}
		}
	}
}
