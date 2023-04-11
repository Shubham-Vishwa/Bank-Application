package atminfo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ATMBean implements Serializable{
	private String accNo;
	private String name;
	private String cardno;
	private String cvv;
	private String cardtype;
	private String mid;
	private String phno;
	private String pin;
	private String atmreldate;
	
	public ATMBean() {}
	public final String getAccNo() {
		return accNo;
	}
	public final void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getCardno() {
		return cardno;
	}
	public final void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public final String getCvv() {
		return cvv;
	}
	public final void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public final String getCardtype() {
		return cardtype;
	}
	public final void setCardtype(String cardtype) {
		this.cardtype = cardtype;
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
	public final String getPin() {
		return pin;
	}
	public final void setPin(String pin) {
		this.pin = pin;
	}
	public final String getAtmreldate() {
		return atmreldate;
	}
	public final void setAtmreldate(String atmreldate) {
		this.atmreldate = atmreldate;
	}
}
