package temptable;
import java.io.Serializable;
@SuppressWarnings("serial")
public class UserBiodataBean implements Serializable{
	private String id;
	private String branchCode;
	private String acctype;
	private String fName;
	private String lName;
	private String dob;
	private String nominee;
	private String nomrel;
	private String occupation;
	private String income;
	private String address;
	private String city;
	private String district;
	private String state;
	private String pin;
	private String mid;
	private String phno;
	
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	public final String getBranchCode() {
		return branchCode;
	}
	public final void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public final String getfName() {
		return fName;
	}
	public final void setfName(String fName) {
		this.fName = fName;
	}
	public final String getlName() {
		return lName;
	}
	public final void setlName(String lName) {
		this.lName = lName;
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
	public final String getIncome() {
		return income;
	}
	public final void setIncome(String income) {
		this.income = income;
	}
	public final String getAddress() {
		return address;
	}
	public final void setAddress(String address) {
		this.address = address;
	}
	public final String getCity() {
		return city;
	}
	public final void setCity(String city) {
		this.city = city;
	}
	public final String getDistrict() {
		return district;
	}
	public final void setDistrict(String district) {
		this.district = district;
	}
	public final String getState() {
		return state;
	}
	public final void setState(String state) {
		this.state = state;
	}
	public final String getPin() {
		return pin;
	}
	public final void setPin(String pin) {
		this.pin = pin;
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
	public final String getAcctype() {
		return acctype;
	}
	public final void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	@Override
	public String toString() {
		return "UserBiodataBean [id=" + id + ", branchCode=" + branchCode + ", acctype=" + acctype + ", fName=" + fName
				+ ", lName=" + lName + ", dob=" + dob + ", nominee=" + nominee + ", nomrel=" + nomrel + ", occupation="
				+ occupation + ", income=" + income + ", address=" + address + ", city=" + city + ", district="
				+ district + ", state=" + state + ", pin=" + pin + ", mid=" + mid + ", phno=" + phno + "]";
	}
}
