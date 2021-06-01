package activities;

public class BankAccount {
	    private Integer balance;
	    
	    // Create a constructor
	    public BankAccount(int initialBalance) {
	        balance = initialBalance;
	    }

	    // Add method to calculate
	    // balance amount after withdrawal
	    public Integer withdraw(int amount) {
	        if (balance < amount) {
	            throw new NotEnoughFundsException(amount, balance);
	        }
	        balance -= amount;
	        return balance;
	    }
}


