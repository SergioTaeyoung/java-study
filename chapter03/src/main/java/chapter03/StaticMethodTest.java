package chapter03;

public class StaticMethodTest {

	public static void main(String[] args) {
		int a = Math.abs(-1);	//abs는 static메소드 new선언 안하고 사용 가능
		int b = Math.max(10, 20);
		System.out.println(a + ":" + b);

	}

}
