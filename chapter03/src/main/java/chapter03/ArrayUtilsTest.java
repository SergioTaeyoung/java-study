package chapter03;

public class ArrayUtilsTest {

	public static void main(String[] args) {
		int[] a1 = { 10, 20, 30, 40, 50 };
		int[] a2 = { 60, 70, 80, 90, 100, 110};
		
		//ArrayUtils au = new ArrayUtils();
		//double[] d1 = au.intToDouble(a1);
		
		double[] d1 = ArrayUtils.intToDouble(a1);
		for(int i = 0; i < d1.length; i++) {
			System.out.print(d1[i] + " ");
		}
		
		System.out.println();

		int[] a3 = ArrayUtils.concat(a1,a2);
//		System.out.println(a3[0]);
		for(int i = 0; i < a1.length+a2.length; i++) {
			//System.out.println(i);
			System.out.print(a3[i] + " ");
		}
	}

}
