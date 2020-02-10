package practice02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		int number = 0;
		double sum = 0;
		
		System.out.println("5개의 숫자를 입력하세요.");

		for(int i=0; i<intArray.length; i++) {
			number = scanner.nextInt();
			
			sum = sum+number;
		}
		System.out.println("평균은 " + (sum/intArray.length) + "입니다");
		/*
		 * 코드 작성합니다.
		 */		
	}

}
