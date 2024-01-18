package ch06_class.sec04_Tmoney;

public class CreditCard {
	private int wallet;
	private int age;

	public CreditCard() {
	}

	public CreditCard(int age, int wallet) {
		this.wallet = wallet;
		this.age = age;
	}

	@Override
	public String toString() {
		return "CreditCard [cash=" + wallet + ", age=" + age + "]";
	}

	public void charge(int cash) {
		wallet += cash;
	}

	public int getCash() {
		return wallet;
	}

	public boolean ride() {
		int credit = 0;

		if (age >= 7 && age <= 12) {
			credit = 730;
		} else if (age >= 13 && age <= 18) {
			credit = 1010;
		} else if (age >= 19){
			credit = 1450;
		} 

		if (wallet >= credit) {
			wallet -= credit;
			return true;
		}
		return false;
	}
}
