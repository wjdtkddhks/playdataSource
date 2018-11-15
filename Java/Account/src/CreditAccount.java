
public class CreditAccount extends Account {
	
		int creditLine;
		
	CreditAccount(String accountNo, String ownerName, int balance, int creditLine)
	{		
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	
	int withdraw(int amount) throws Exception {
		
		if((balance + creditLine) < amount)
			throw new Exception("잔액이 부족합니다");

		balance -= amount;
			return amount;
	}
	
}

