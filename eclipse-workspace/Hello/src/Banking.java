
public class Banking {

	public static void main(String[] args) {
		BankingAccount from = new BankingAccount();
		BankingAccount to = new BankingAccount();
		Transaction tx = new Transaction();
		
		tx.transact(from, to, 10);
		
		from.print();
		to.print();
		
		to = from;

	}

}
