package mypackage;

public class Goods {

	public static int countOfGoods;
	public Goods() {
		Goods.countOfGoods ++;
	}
	
	public String name;		//접근제한이업슴
	protected int price;	//같은 패키지 + 자식 접근 가능
	int countSold;			//같은 패키지
	private int countStock;	//하나의 클래스에서만 접근가능
	
}
