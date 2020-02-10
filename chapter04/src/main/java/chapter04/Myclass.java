package chapter04;

public class Myclass {
	private static Myclass instance = null;
	
	private Myclass() {
		
	}
	public static Myclass getInstance() {
		if(instance == null) {
			instance = new Myclass();
			
		}
		return instance;
	}
}
