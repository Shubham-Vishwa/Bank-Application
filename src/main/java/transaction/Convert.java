package transaction;

public class Convert {
	
	public static int toInt(String st) {
		if(st.equals("")) {
			return 0;
		}else {
			return Integer.parseInt(st);
		}
	}
}
