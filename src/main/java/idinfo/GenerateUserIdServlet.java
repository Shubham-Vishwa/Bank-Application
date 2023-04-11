package idinfo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/genuserid")
public class GenerateUserIdServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = new GenerateUserIdDAO().getId();
		request.setAttribute("uid", userId);
		RequestDispatcher rd = request.getRequestDispatcher("customer.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
//		String html = "<!DOCTYPE html>\r\n"
//				+ "<html>\r\n"
//				+ "<head>\r\n"
//				+ "<meta charset=\"ISO-8859-1\">\r\n"
//				+ "<title>Open Account</title>\r\n"
//				+ "<style>\r\n"
//				+ "	#main{\r\n"
//				+ "		width:500px;\r\n"
//				+ "		margin:10px auto;\r\n"
//				+ "		padding:20px;\r\n"
//				+ "		box-shadow:3px 3px 10px;\r\n"
//				+ "	}\r\n"
//				+ "	h4{\r\n"
//				+ "		display:inline;\r\n"
//				+ "		color:red;\r\n"
//				+ "		text-align:center;\r\n"
//				+ "	}\r\n"
//				+ "	.heading{\r\n"
//				+ "		background:#e9e9e9;\r\n"
//				+ "		text-align:center;\r\n"
//				+ "	}\r\n"
//				+ "</style>\r\n"
//				+ "</head>\r\n"
//				+ "<body>\r\n"
//				+ "<div id=\"main\">\r\n"
//				+ "  <div id=\"sub1\"><h2>Account Opening Form</h2></div>\r\n"
//				+ "    <div id=\"sub2\">\r\n"
//				+ "	  <form action=\"userbiodata\" method=\"post\">\r\n"
//				+ "		<table>\r\n"
//				+ "		  <tr><td colspan=2 class=\"heading\"><h4>Personal Details</h4></td></tr>\r\n"
//				+ "		  <tr><td>Customer Id:</td><td><input type=\"text\" name=\"id\" value="+userId+" readonly/></td></tr>\r\n"
//				+ "		  <tr><td>Branch Name:</td><td>\r\n"
//				+ "		  							<select name=\"brcode\">\r\n"
//				+ "		  								<option value=\"na\">--Select--</option>\r\n"
//				+ "		  								<option value=\"1001\">Varanasi</option>\r\n"
//				+ "		  								<option value=\"1002\">Noida</option>\r\n"
//				+ "		  								<option value=\"1003\">Hyderabad</option>\r\n"
//				+ "		  								<option value=\"1004\">Banglore</option>\r\n"
//				+ "		  							</select>\r\n"
//				+ "		  							</td></tr>\r\n"
//				+ "		  <tr><td>Account Type:</td><td>\r\n"
//				+ "		  							<select name=\"acctype\">\r\n"
//				+ "		  								<option value=\"na\">--Select--</option>\r\n"
//				+ "		  								<option value=\"saving\">Saving account</option>\r\n"
//				+ "		  								<option value=\"current\">Current account</option>\r\n"
//				+ "		  							</select>\r\n"
//				+ "		  							</td></tr>\r\n"
//				+ "		  <tr><td>First Name:</td><td><input type=\"text\" name=\"fname\"/></td></tr>\r\n"
//				+ "		  <tr><td>Last Name:</td><td><input type=\"text\" name=\"lname\"/></td></tr>\r\n"
//				+ "		  <tr><td>Date of Birth:</td><td><input type=\"date\" name=\"dob\"/></td></tr>\r\n"
//				+ "		  <tr><td>Nominee Name:</td><td><input type=\"text\" name=\"nominee\"/></td></tr>\r\n"
//				+ "		  <tr><td>Relation with Nominee:</td><td><input type=\"text\" name=\"nomrel\"/></td></tr>\r\n"
//				+ "		  <tr><td colspan=2 class=\"heading\"><h4>Occupation Details</h4></td></tr>\r\n"
//				+ "		  <tr><td>Occupation Type/Service:</td><td>\r\n"
//				+ "		  								<select name=\"occupation\">\r\n"
//				+ "		  									<option value=\"na\">--Select--</option>\r\n"
//				+ "		  									<option value=\"defence\">Defence</option>\r\n"
//				+ "		  									<option value=\"bussiness\">Bussiness</option>\r\n"
//				+ "		  									<option value=\"govemp\">Government Employee</option>\r\n"
//				+ "		  									<option value=\"privemp\">Private Employee</option>\r\n"
//				+ "		  								</select>\r\n"
//				+ "		  								</td></tr>\r\n"
//				+ "		  <tr><td>Annual Income:</td><td><input type=\"text\" name=\"income\"/>Rs:</td></tr>\r\n"
//				+ "		  <tr><td colspan=2 class=\"heading\"><h4>Address Details</h4></td></tr>\r\n"
//				+ "		  <tr><td>Address:</td><td><input type=\"text\" name=\"add\"/></td></tr>\r\n"
//				+ "		  <tr><td>City:</td><td><input type=\"text\" name=\"city\"/></td></tr>\r\n"
//				+ "		  <tr><td>District:</td><td><input type=\"text\" name=\"district\"/></td></tr>\r\n"
//				+ "		  <tr><td>State:</td><td><input type=\"text\" name=\"state\"/></td></tr>\r\n"
//				+ "		  <tr><td>Pin Code:</td><td><input type=\"text\" name=\"pin\"/></td></tr>\r\n"
//				+ "		  <tr><td colspan=2 class=\"heading\"><h4>Contact Details</h4></td></tr>\r\n"
//				+ "		  <tr><td>Email Id:</td><td><input type=\"text\" name=\"mid\"/></td></tr>\r\n"
//				+ "		  <tr><td>Phone Number:</td><td><input type=\"text\" name=\"phno\"/></td></tr>\r\n"
//				+ "		  <tr><td colspan=2><input type=\"checkbox\" required />I allow Bank's correspondence to call/SMS me with reference to my application\r\n"
//				+ "		  </td></tr>"
//				+ "		  <tr><td></td><td><input type=\"submit\" value=\"Submit Form\"/></td></tr>\r\n"
//				+ "		</table>\r\n"
//				+ "	 </form>\r\n"
//				+ "  </div>\r\n"
//				+ "</div>\r\n"
//				+ "</body>\r\n"
//				+ "</html>\r\n";
//		
//		pw.print(html);
	}

}
