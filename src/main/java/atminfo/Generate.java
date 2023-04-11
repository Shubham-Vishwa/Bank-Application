package atminfo;
import java.util.Random;
public class Generate {
	
	public static String cardNo(String accno) {
		String ans = ""+new Random().nextInt(100000,999999);
		for(int i=0;i<4;i++) {
			ans+=accno.charAt(i);
		}
		return ans;
	}
	public static String txn(String accno) {
		String ans = "TXN"+new Random().nextInt(100,999);
		for(int i=0;i<4;i++) {
			ans+=accno.charAt(i);
		}
		return ans;
	}
}
