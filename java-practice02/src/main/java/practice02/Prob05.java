package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random r = new Random();
		int k = r.nextInt(100) + 1;
		int number = 0;
		String answer;
		int maxNum=100;
		int minNum=1;
		int i =1;
		boolean regame = false;

		System.out.println("맞춰보세요");

		while (true) {
			regame = false;
			
			System.out.print(i + ">>");
			number = scanner.nextInt();

			if (number == k) {
				System.out.println("맞았습니다");
				System.out.println("다시 하시겠습니까?(y/n)");
				answer = scanner.next();
				if (answer.equals("y")) {
					k = r.nextInt(100) + 1;
					i = 0;
					minNum=1;
					maxNum=100;
					regame = true;
				} else
					break;

			} else if (number < k) {
				System.out.println("더 높게");
				System.out.println(number + "-" + maxNum );
				minNum= number;

			} else if (number > k) {
				System.out.println("더 낮게");
				System.out.println(minNum + "-" + number);
				maxNum = number;
			}
			i++;
			if(regame)
				continue;
			
		}

		
	}
}
