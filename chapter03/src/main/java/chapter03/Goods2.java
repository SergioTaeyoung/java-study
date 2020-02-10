package chapter03;

public class Goods2 {
	
	
	
	private String name;		//접근제한이업슴
	private int price;	//같은 패키지 + 자식 접근 가능
	private int countSold;			//같은 패키지
	private int countStock;	//하나의 클래스에서만 접근가능
	
	public Goods2() {
		
	}
	
	public Goods2(String name, int price, int countSold, int countStock) {
		this.name = name;
		this.price = price;
		this.countSold = countSold;
		this.countStock = countStock;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price < 0)
			price = 0;
		this.price = price;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	public void showInfo() {
		System.out.println(this.name + ":" + this.price + ":" + this.countStock + ":" + this.countSold);
	}
	public int calcDiscountPrice(double discountRate) {
		
		return (int)(price - price*discountRate);
	}
	

}
