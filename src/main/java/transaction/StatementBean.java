package transaction;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StatementBean implements Serializable{
	private String accno;
	private String refno;
	private String transdate;
	private String transdesc;
	private int debit;
	private int credit;
	private int netBal;
	
	public StatementBean() {}

	public final String getAccno() {
		return accno;
	}

	public final void setAccno(String accno) {
		this.accno = accno;
	}

	public final String getRefno() {
		return refno;
	}

	public final void setRefno(String refno) {
		this.refno = refno;
	}

	public final String getTransdate() {
		return transdate;
	}

	public final void setTransdate(String transdate) {
		this.transdate = transdate;
	}

	public final String getTransdesc() {
		return transdesc;
	}

	public final void setTransdesc(String transdesc) {
		this.transdesc = transdesc;
	}

	public final int getDebit() {
		return debit;
	}

	public final void setDebit(int debit) {
		this.debit = debit;
	}

	public final int getCredit() {
		return credit;
	}

	public final void setCredit(int credit) {
		this.credit = credit;
	}

	public final int getNetBal() {
		return netBal;
	}

	public final void setNetBal(int netBal) {
		this.netBal = netBal;
	}

	@Override
	public String toString() {
		return "<div style='width:800px; display:grid; margin:auto; grid-template-columns:100px 100px 175px 200px 75px 75px 75px; background:yellow; padding:10px;'>"
				+ "<label>"+accno+"</label><label>"+refno+"</label><label>"+transdate+"</label>"+
				"<label>"+transdesc+"</label><label>"+debit+"</label><label>"+credit+"</label>"
				+ "<label>"+netBal+"</label></div>";
	}
	
	
}
