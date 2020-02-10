package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		Scanner scanner = new Scanner(System.in);

		System.out.print("금액:");

		int cash = scanner.nextInt();
		
		while(cash != 0) {
			
			System.out.println("50000원권 : " + cash/50000);
			cash = cash % 50000;
			
			System.out.println("10000원권 : " + cash/10000);
			cash = cash % 10000;
			
			
			System.out.println("5000원권 : " + cash/5000);
			cash = cash % 5000;
			
			
			System.out.println("1000원권 : " + cash/1000);
			cash = cash % 1000;
			
			
			System.out.println("500원권 : " + cash/500);
			cash = cash % 500;
			
			
			System.out.println("100원권 : " + cash/100);
			cash = cash % 100;
			
			System.out.println("50원권 : " + cash/50);
			cash = cash % 50;
			
			System.out.println("10원권 : " + cash/10);
			cash = cash % 10;
			
			System.out.println("5원권 : " + cash/5);
			cash = cash % 5;
			
			System.out.println("1원권 : " + cash);
			cash = 0;
			
		}
		/*
		 * 코드 작성합니다.
		 */
		
		scanner.close();
	}

}
