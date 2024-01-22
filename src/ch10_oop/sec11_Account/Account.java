package ch10_oop.sec11_Account;

public class Account {
	int balance;
	
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	
	
	public Account() {}
	
	public Account(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		if(!(balance > MAX_BALANCE || balance < MIN_BALANCE)) {
			this.balance += balance;
		}
	}
	
}
