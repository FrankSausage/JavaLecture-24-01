package ch12_interface.sec11_bank;

import java.util.Scanner;

public class AccountMain {
	private static Account[] account = new Account[100];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		AccountService ac = new AccountServiceImpl();
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
				ac.createAccount(account);
				break;
			case 2:
				ac.accountList(account);
				break;
			case 3:
				ac.deposit(account);
				break;
			case 4:
				ac.withdraw(account);
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("올바른 번호를 입력 해 주세요.");
			}
		}
		
		System.out.println("프로그램 종료");
	}
}
