package ch06_class.sec04_Tmoney;

import java.util.Scanner;

public class CreditCardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이> ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("금액> ");
		int cash = Integer.parseInt(sc.nextLine());
		sc.close();
		
		CreditCard card = new CreditCard(age, cash);
		Tmoney tm = new Tmoney(age, cash);
		
		System.out.println(card);
		System.out.println(tm);
		
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!tm.ride()) {
				break;
			}
			System.out.print(i + "회 탑승 후");
			System.out.println(tm);
		}
		
		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!card.ride()) {
				break;
			}
			System.out.print(i + "회 탑승 후");
			System.out.println(card);
		}
		
//		card.charge(10000);
//		System.out.println(card);
//		System.out.println(card.getCash());
//		System.out.println(card.ride());
//		System.out.println(card.getCash());
	}

}
