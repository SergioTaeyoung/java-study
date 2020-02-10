package prob4;

public class StringUtil {
	public static String concatenate(String[] str) {
		String conStr = "";
		for(int i = 0; i<str.length; i++) {
			conStr = conStr + str[i];
			
		}
		return conStr;
	}
}
