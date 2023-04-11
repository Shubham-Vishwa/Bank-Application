package userinfo;
import java.io.Serializable;
@SuppressWarnings("serial")
public class UserBean implements Serializable{
	private String fName;
	private String lName;
	private String pass;
	private String mid;
	private long phno;
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
	public final String getPass() {
		return pass;
	}
	public final void setPass(String pass) {
		this.pass = pass;
	}
	public final String getMid() {
		return mid;
	}
	public final void setMid(String mid) {
		this.mid = mid;
	}
	public final long getPhno() {
		return phno;
	}
	public final void setPhno(long phno) {
		this.phno = phno;
	}
	
}
