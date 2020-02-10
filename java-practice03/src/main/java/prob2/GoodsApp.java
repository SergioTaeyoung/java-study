package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		String name;
		int price;
		int stock;
		for(int i =0; i<3; i++) {
			goods[i] = new Goods();
		}
		
		
		for(int i=0; i<3; i++) {
			
			System.out.println("상품명을 입력하세요");		
			name = scanner.next();
			goods[i].setName(name);
			
			System.out.println("가격을 입력하세요");	
			price = scanner.nextInt();
			goods[i].setPrice(price);
			
			System.out.println("개수를 입력하세요");	
			stock = scanner.nextInt();
			goods[i].setStock(stock);
			
			
		
		
		}
		for(int i =0; i<3; i++) {
			System.out.println(goods[i].getName() + "(가격:" + goods[i].getPrice() + ")이 " + goods[i].getStock() + " 개 입고되었습니다.");
		}
		


		scanner.close();
	}
}
