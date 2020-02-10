package chapter03;

public class ArrayUtils {
	public static double[] intToDouble(int[] src) {
		double[] result = null;

		if (src == null) {
			return null;
		}

		int size = src.length;
		result = new double[size];

		for (int i = 0; i < size; i++) {
			result[i] = src[i];
		}
		return result;
	}

	public static int[] concat(int[] s1, int[] s2) {
		int a = s1.length;
		int b = s2.length;
		int j = 0;

		int[] s3 = new int[a + b];

		for (int i = 0; i < a + b; i++) {
			if (j < a) {
				s3[i] = s1[j];
				j++;
			} else
				s3[i] = s2[i - j];
		}

		return s3;
	}
}
