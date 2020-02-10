package practice02;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
		char[] c3 = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			int a = str.length() - 1 - i;
			c3[i] = str.charAt(a);
		}

		return c3;
	}

	public static void printCharArray(char[] array) {
		System.out.println(array);
	}
}
