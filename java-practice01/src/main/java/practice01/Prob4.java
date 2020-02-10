package practice01;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");

		String str = scanner.nextLine();
		
		
		/*
		 * 코드 작성합니다.
		 */
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j <i+1; j++)
				System.out.print(str.charAt(j));
			System.out.println();
		}
		
		
		scanner.close();
	}

}
