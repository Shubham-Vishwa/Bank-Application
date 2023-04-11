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
@WebServlet("/transfermoney")
public class TransferMoneyServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		HttpSession hs = request.getSession(false);
		if(hs==null) {
			pw.print("<script>window.alert('Session expired...')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}else {
			TransBean b = (TransBean)hs.getAttribute("transbean");
			TransferBean tb = new TransferBean();
			
			tb.setAmount(Integer.parseInt(request.getParameter("amt")));
			tb.setTotbal(b.getTotbal());
			if(tb.getAmount()<=tb.getTotbal()) {
				tb.setAccno(b.getAccno());
				tb.setBaccno(request.getParameter("baccno"));
				tb.setTxnid(Generate.txn(b.getAccno()));
				tb.setTransdate(request.getParameter("transferdate"));
				
				String transdesc1 = "Rs:"+tb.getAmount()+" transfered to acc:"+tb.getBaccno();
				tb.setTransdesc1(transdesc1);
				String transdesc2 = "Rs:"+tb.getAmount()+" transfered from acc:"+tb.getAccno();
				tb.setTransdesc2(transdesc2);
				
				int k = new TransferMoneyDAO().transfer(tb);
				if(k>0) {
					b.setTotbal(tb.getTotbal()-tb.getAmount());
					pw.print("<script>window.alert('Transaction successfull...')</script>");
				}else {
					pw.print("<h2 style='text-align:center; background:#f0f0f0;'>Beneficiery account not found...OR<br/>"
							+ "Your account is not active...</h2>");
				}
			}else {
				pw.print("<script>window.alert('Insufficient account balance...')</script>");
				pw.print("<h2>Available balance: "+tb.getTotbal()+"</h2>");
			}
			RequestDispatcher rd2 = request.getRequestDispatcher("transaction.html");
			rd2.include(request, response);
			
		}
		
	}

}
