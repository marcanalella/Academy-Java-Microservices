public class BankingAccount {
	private int amount;
	private String accountName;
	
	public void deposit(int money) {
		amount = amount + money;
	}
	
	public void withdraw(int money) {
		amount = amount - money;
	}
	
	public void print() {
		System.out.println("acc. " + accountName + " " 
						   + amount + " EUR");
	}
}