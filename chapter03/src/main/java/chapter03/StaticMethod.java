package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1(){
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(m);
		//System.out.println(StaticMethod.m); 원칙은 이거지만 같은 클래스의 클래스변수 접근에서는 클래스 이름을 생략 가능하다
	}
	
	void f3() {
		StaticMethod.s1();
		
		//s1();	같은 클래스라 생략가능
	}
	
	static void s1() {
		//error : static method에서 인스턴스 변수 접근은 안된다.
		//System.out.println(n);
	}
		
	static void s2() {
		System.out.println(m);
	}
	
	static void s3() {
		// f1(); error : static method에서 인스턴스 메소드 접근은 안된다.
	}
	
	static void s4() {
		StaticMethod.s1();
		// s1(); 클래스 이름 생략가능
	}
}
