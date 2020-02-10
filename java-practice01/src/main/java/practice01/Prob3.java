package practice01;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("숫자를 입력하세요 : " );
		int number = scanner.nextInt();
		int sum=0;
		
		
		while (true) {
			if(number%2 == 0)
				for(int i=0; i<=number;) {
					sum += i;
					i += 2;
					
				}
			else
				for(int i=1; i<=number;) {
					sum += i;
					i +=2;
					
				}
			break;
		}
		System.out.println("결과값 : " + sum);
	}
}
