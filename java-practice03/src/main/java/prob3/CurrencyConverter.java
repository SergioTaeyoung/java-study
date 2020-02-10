package prob3;

public class CurrencyConverter {
	private static double rate;
	
	public static double toDollar(double won) {
		double Dollor=0;
		Dollor = won / rate;
		return Dollor;
	}
	
	public static double toKRW(double dollar) {
		double won;
		won = dollar * rate;
		return won;
	}
	
	public static void setRate(double r) {
		rate = 1170/1;
	}

}
