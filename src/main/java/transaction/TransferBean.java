package transaction;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TransferBean implements Serializable{
	private String accno;
	private String baccno;
	private String txnid;
	private int amount;
	private String transdate;
	private String transdesc1;
	private String transdesc2;
	private int totbal;

	
	public TransferBean() {}

	public final String getAccno() {
		return accno;
	}

	public final void setAccno(String accno) {
		this.accno = accno;
	}

	public final String getBaccno() {
		return baccno;
	}

	public final void setBaccno(String baccno) {
		this.baccno = baccno;
	}

	public final String getTxnid() {
		return txnid;
	}

	public final void setTxnid(String txnid) {
		this.txnid = txnid;
	}

	public final int getAmount() {
		return amount;
	}

	public final void setAmount(int amount) {
		this.amount = amount;
	}

	public final String getTransdate() {
		return transdate;
	}

	public final void setTransdate(String transdate) {
		this.transdate = transdate;
	}

	public final String getTransdesc1() {
		return transdesc1;
	}

	public final void setTransdesc1(String transdesc1) {
		this.transdesc1 = transdesc1;
	}

	public final String getTransdesc2() {
		return transdesc2;
	}

	public final void setTransdesc2(String transdesc2) {
		this.transdesc2 = transdesc2;
	}

	public final int getTotbal() {
		return totbal;
	}

	public final void setTotbal(int totbal) {
		this.totbal = totbal;
	}	
	
}
