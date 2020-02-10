package practice01;

public class Prob5 {

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {

			/*
			 * 코드 작성합니다.
			 */

			String s = String.valueOf(i);
			boolean isChark = false;

			for (int j = 0; j < s.length(); j++) {
				char chk = s.charAt(j);
				if (chk == '3' || chk == '6' || chk == '9')
					isChark = true;
			}
			if (isChark) {
				System.out.print(i);

				for (int j = 0; j < s.length(); j++) {
					char chk = s.charAt(j);
					if (chk == '3' || chk == '6' || chk == '9') {
						System.out.print("짝");

					}

				}
				System.out.println();
			}
		}

	}
}
