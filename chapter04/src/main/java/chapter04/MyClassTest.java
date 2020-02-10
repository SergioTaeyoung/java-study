package chapter04;

public class MyClassTest {

	public static void main(String[] args) {
		//new Myclass();
		
		Myclass myClass1 = Myclass.getInstance();
		Myclass myClass2 = Myclass.getInstance();
		Myclass myClass3 = Myclass.getInstance();
		
		System.out.println(myClass1==myClass2);
		System.out.println(myClass2==myClass3);
	}
	

}
