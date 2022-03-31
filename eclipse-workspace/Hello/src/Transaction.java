
public class Transaction {
	
	public void transact  (BankingAccount from,
				     	   BankingAccount to,
					       int money) {
		from.withdraw(money);
		to.deposit(money);
	}

}
