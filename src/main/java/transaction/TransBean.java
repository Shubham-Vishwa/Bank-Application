package transaction;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TransBean implements Serializable{
	private String accno;
	private String name;
	private String mid;
	private String phno;
	private String lastlogin;
	private int totbal;
	
	public TransBean() {}

	public final String getAccno() {
		return accno;
	}

	public final void setAccno(String accno) {
		this.accno = accno;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getMid() {
		return mid;
	}

	public final void setMid(String mid) {
		this.mid = mid;
	}

	public final String getPhno() {
		return phno;
	}

	public final void setPhno(String phno) {
		this.phno = phno;
	}

	public final String getLastlogin() {
		return lastlogin;
	}

	public final void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}

	public final int getTotbal() {
		return totbal;
	}

	public final void setTotbal(int totbal) {
		this.totbal = totbal;
	}


	

}
