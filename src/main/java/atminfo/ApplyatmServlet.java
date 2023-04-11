package atminfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/applyatm")
public class ApplyatmServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		ATMBean bean = new ATMBean();
		bean.setAccNo(req.getParameter("accno"));
		bean.setCardno(Generate.cardNo(bean.getAccNo()));
		bean.setCvv(new Random().nextInt(100,999)+"");
		bean.setCardtype(req.getParameter("ctype"));
		bean.setMid(req.getParameter("mid"));
		bean.setPhno(req.getParameter("phno"));
		bean.setPin(req.getParameter("pin1"));
		bean.setAtmreldate(req.getParameter("atmdate"));
		int k = new ApplyatmDAO().apply(bean);
		if(k>0) {
			pw.print("<h2>Thanks for applying ATM</h2>");
		}else {
			pw.print("<h2>Email Id or Phone number not matched</h2>");
		}
		RequestDispatcher rd = req.getRequestDispatcher("customer.jsp");
		rd.include(req, res);
		
		
		
		
		
//		if(!(mpb==null)) {
//			if(mpb.getMid().equals(bean.getMid())){
//				if(mpb.getPhno().equals(bean.getPhno())) {
//					pw.print("<h2>Thanks for applying for ATM Card</h2>");
//					RequestDispatcher rd = req.getRequestDispatcher("customer.jsp");
//					rd.include(req, res);
//				}else {
//					pw.print("<script>window.alert('Please enter registered Phone Number</script>");
//				}
//			}else {
//				pw.print("<script>window.alert('Please enter registered Mail Id</script>");
//			}
//		}else {
//			pw.print("<script>window.alert('Please enter registered Account Number')</script>");
//		}
	}

}
