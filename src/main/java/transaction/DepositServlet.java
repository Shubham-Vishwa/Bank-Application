package transaction;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import atminfo.Generate;

@SuppressWarnings("serial")
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			pw.print("<script>window.alert('Session already expired...')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}else {
			int two000 = Convert.toInt(request.getParameter("two000"));
			int five00 = Convert.toInt(request.getParameter("five00")); 
			int two00 = Convert.toInt(request.getParameter("two00"));
			int one00 = Convert.toInt(request.getParameter("one00"));
			int money = two000*2000+five00*500+two00*200+one00*100;
			
			TransBean b = (TransBean)session.getAttribute("transbean");
			StatementBean sb = new StatementBean();
			sb.setAccno(b.getAccno());
			sb.setRefno(Generate.txn(b.getAccno()));
			sb.setTransdate(request.getParameter("transdate"));
			String desc = "₹"+money+" deposited by cash";
			sb.setTransdesc(desc);
			sb.setDebit(0);
			sb.setCredit(money);
			sb.setNetBal(b.getTotbal()+money);
			int k = new DepositDAO().deposit(sb);
			if(k>0) {
				b.setTotbal(sb.getNetBal());
				pw.print("<script>window.alert('Money deposited...Available bal:"+sb.getNetBal()+"')</script>");
			}else {
				sb.setNetBal(b.getTotbal());
				pw.print("<h2>Money not deposited....</h2>");
			}
			RequestDispatcher rd = request.getRequestDispatcher("transaction.html");
			rd.include(request, response);
		}
		
	}
}
