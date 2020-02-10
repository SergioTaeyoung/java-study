package prob5;

public class Account {

	private String accountNO;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNO = accountNo;
		
		System.out.println(this.accountNO + "계좌가 생성되었습니다.");
	}

	public String getAccountNO() {
		return accountNO;
	}

	public void setAccountNO(String accountNO) {
		this.accountNO = accountNO;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void save(int money) {
		System.out.println(this.accountNO + "계좌에" + money + "만원이 입금되었습니다.");
		this.balance = this.balance + money;
		
	}
	public void deposit(int money) {
		System.out.println(this.accountNO + "계좌에" + money + "만원이 출금되었습니다.");
		this.balance = this.balance - money;
	}
}