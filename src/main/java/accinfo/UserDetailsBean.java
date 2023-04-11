package accinfo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserDetailsBean implements Serializable{
	private String userid;
	private String accno;
	private String brcode;
	private String acctype;
	private String status;
	private String risk;
	private String name;
	private String dob;
	private String nominee;
	private String nomrel;
	private String occupation;
	private int income;
	private String fulladd;
	private String mid;
	private String phno;
	private String adminName;
	private String remark;
	public UserDetailsBean() {}
	public final String getUserid() {
		return userid;
	}
	public final void setUserid(String userid) {
		this.userid = userid;
	}
	public final String getAccno() {
		return accno;
	}
	public final void setAccno(String accno) {
		this.accno = accno;
	}
	public final String getBrcode() {
		return brcode;
	}
	public final void setBrcode(String brcode) {
		this.brcode = brcode;
	}
	public final String getAcctype() {
		return acctype;
	}
	public final void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public final String getStatus() {
		return status;
	}
	public final void setStatus(String status) {
		this.status = status;
	}
	public final String getRisk() {
		return risk;
	}
	public final void setRisk(String risk) {
		this.risk = risk;
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final String getDob() {
		return dob;
	}
	public final void setDob(String dob) {
		this.dob = dob;
	}
	public final String getNominee() {
		return nominee;
	}
	public final void setNominee(String nominee) {
		this.nominee = nominee;
	}
	public final String getNomrel() {
		return nomrel;
	}
	public final void setNomrel(String nomrel) {
		this.nomrel = nomrel;
	}
	public final String getOccupation() {
		return occupation;
	}
	public final void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public final int getIncome() {
		return income;
	}
	public final void setIncome(int income) {
		this.income = income;
	}
	public final String getFulladd() {
		return fulladd;
	}
	public final void setFulladd(String fulladd) {
		this.fulladd = fulladd;
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
	public final String getAdminName() {
		return adminName;
	}
	public final void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public final String getRemark() {
		return remark;
	}
	public final void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "<div style='width:1500px; display:inline; display:grid; margin:auto; grid-template-columns:50px 100px 75px 75px 75px 75px 150px 100px 100px 75px 75px 75px 200px 150px 75px; background:yellow; padding:10px;'>"
				+ "<label>"+userid+"</label><label>"+accno+"</label><label>"+brcode+"</label>"+
				"<label>"+acctype+"</label><label>"+status+"</label><label>"+risk+"</label>"
				+ "<label>"+name+"</label><label>"+dob+"</label><label>"+nominee+"</label>"
				+ "<label>"+nomrel+"</label><label>"+occupation+"</label><label>"+income+"</label>"+
				"<label>"+fulladd+"</label><label>"+mid+"</label><label>"+phno+"</label></div>";

	}
	private String getBranch(String brcode) {
		return switch(brcode) {
		case "1001":yield "Varanasi";
		case "1002":yield "Noida";
		case "1003":yield "Hyderabad";
		case "1004":yield "Banglore";
		default:yield "";
		};
	}
	public String display() {
		return "<div style='width:500px; text-font:25px; display:grid; grid-template-columns:200px 200px; margin:50px auto; border:5px double; padding:30px;'>"
				+ "<label>User Id:</label><label>"+userid+"</label>"
				+ "<label>Account Number:</label><label>"+accno+"</label>"
				+ "<label>Branch Code and Name:</label><label>"+brcode+" "+getBranch(brcode)+"</label>"
				+ "<label>Account Type:</label><label>"+acctype+"</label>"
				+ "<label>Status:</label><label>"+status+"</label>"
				+ "<label>Risk Category:</label><label>"+risk+"</label>"
				+ "<label>Baneficiary:</label><label>"+name+"</label>"
				+ "<label>Date of Birth:</label><label>"+dob+"</label>"
				+ "<label>Nominee Name:</label><label>"+nominee+"</label>"
				+ "<label>Nominee Relation:</label><label>"+nomrel+"</label>"
				+ "<label>Occupation:</label><label>"+occupation+"</label>"
				+ "<label>Income:</label><label>"+income+"</label>"
				+ "<label>Address:</label><label>"+fulladd+"</label>"
				+ "<label>Mail Id:</label><label>"+mid+"</label>"
				+ "<label>Phone Number:</label><label>"+phno+"</label>"
				+ "</div>";
	}
}
