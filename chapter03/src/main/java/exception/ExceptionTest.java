package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 11 - a;
		
		System.out.println("some code0");
		
		try {
			System.out.println("some code1");
			int result = (1 + 2 + 3) / b;
			System.out.println("some code2");
		} catch (ArithmeticException ex) {
			System.out.println("some code3");
			System.out.println("예외 발생:" + ex);
			// 1.사과
			System.out.println("미안합니다....");
			// 2.로그 남기기(파일,DB)
			System.out.println(ex);
			// 3.정상종료
			return;			
		}finally {
			System.out.println("some code4");
		}
		System.out.println("some code5");
	}

}
