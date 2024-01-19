package ch10_oop.sec12_BankApp;

import java.util.*;

public class BankApplication {
	private static Account[] accountarray = new Account[100];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		
		while (run) {
			System.out.println();
			System.out.println("---------------------------------------------------");
			System.out.println("1. 계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(sc.nextLine());

			switch (selectNo) {
			case 1:
				createAccount();
				continue;
			case 2:
				accountList();
				continue;
			case 3:
				deposit();
				continue;
			case 4:
				withdraw();
				continue;
			case 5:
				run = false;
				break;
			default:
				run = true;
			}
		}
		System.out.println("프로그램 종료");
	}

	private static void createAccount() {
		System.out.println("-----------");
		System.out.println("계좌생성");
		System.out.println("-----------");

		System.out.print("계좌번호: ");
		String creatAno = sc.nextLine();
		System.out.print("계좌주: ");
		String creatOwner = sc.nextLine();
		System.out.print("초기입금액: ");
		int firstBalance = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < accountarray.length; i++) {
			if (accountarray[i] == null) {
				accountarray[i] = new Account(creatAno, creatOwner, firstBalance);
				break;
			}
		}

		System.out.println("결과: 계좌가 생성되었습니다.");
	}

	private static void accountList() {
		System.out.println("-----------");
		System.out.println("계좌목록");
		System.out.println("-----------");

		for (int i = 0; i < accountarray.length; i++) {
			if (accountarray[i] != null) {
				System.out.println(accountarray[i].getAno() + "   " + accountarray[i].getOwner() + "   "
						+ accountarray[i].getBalance());
				continue;
			}
			break;
		}
	}

	private static void deposit() {
		System.out.println("-----------");
		System.out.println("예금");
		System.out.println("-----------");

		System.out.print("계좌번호: ");
		String findAno = sc.nextLine();
		System.out.print("예금액: ");
		int depoBalance = Integer.parseInt(sc.nextLine());

		Account depoArr = findAccount(findAno);

		if (depoArr != null) {
			depoArr.setBalance(depoArr.getBalance() + depoBalance);
			System.out.println("결과: 예금이 성공되었습니다.");
		} else {
			System.out.println("결과: 계좌가 존재하지 않습니다.");
		}
	}

	private static void withdraw() {
		System.out.println("-----------");
		System.out.println("출금");
		System.out.println("-----------");

		System.out.print("계좌번호: ");
		String findAno = sc.nextLine();
		System.out.print("예금액: ");
		int wdBalance = Integer.parseInt(sc.nextLine());

		Account depoArr = findAccount(findAno);

		if (depoArr != null) {
			if (!(depoArr.getBalance() < wdBalance)) {
				depoArr.setBalance(depoArr.getBalance() - wdBalance);
				System.out.println("결과: 출금이 성공되었습니다.");
			} else {
				System.out.println("결과: 잔액이 부족합니다.");
			}
		} else {
			System.out.println("결과: 계좌가 존재하지 않습니다.");
		}
	}

	private static Account findAccount(String ano) {
		Account account = null;

		for (int i = 0; i < accountarray.length; i++) {
			if (accountarray[i] != null) {
				String accountStr = accountarray[i].getAno();
				if (accountStr.equals(ano)) {
					account = accountarray[i];
					break;
				}
			}
		}

		return account;
	}
}
