package prob6;

public class Mul {
	
	int a;
	int b;
	
	public void setValue(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public int calculate() {
		int sol = 0;
		sol = this.a * this.b;
		return sol;
	}

}
