package ch12_interface.sec11_bank;

import java.util.Scanner;

public class AccountServiceImpl implements AccountService {
	private static Scanner sc = new Scanner(System.in);
		

	@Override
	public void createAccount(Account[] accountArray) {
		System.out.println("-----------");
		System.out.println("계좌생성");
		System.out.println("-----------");

		System.out.print("계좌번호: ");
		String creatAno = sc.nextLine();
		System.out.print("계좌주: ");
		String creatOwner = sc.nextLine();
		System.out.print("초기입금액: ");
		int firstBalance = Integer.parseInt(sc.nextLine());
		
		Account newAC = new Account(creatAno, creatOwner, firstBalance);
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = newAC;
				break;
			}
		}

		System.out.println("결과: 계좌가 생성되었습니다.");
	}

	@Override
	public void accountList(Account[] accountArray) {
		System.out.println("-----------");
		System.out.println("계좌목록");
		System.out.println("-----------");

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				System.out.println(accountArray[i].getAno() + "   " + accountArray[i].getOwner() + "   "
						+ accountArray[i].getBalance());
				continue;
			}
			break;
		}
	}

	@Override
	public void deposit(Account[] accountArray) {
		System.out.println("-----------");
		System.out.println("예금");
		System.out.println("-----------");

		System.out.print("계좌번호: ");
		String findAno = sc.nextLine();
		System.out.print("예금액: ");
		int depoBalance = Integer.parseInt(sc.nextLine());

		Account depoArr = findAccount(findAno, accountArray);

		if (depoArr != null) {
			depoArr.setBalance(depoArr.getBalance() + depoBalance);
			System.out.println("결과: 예금이 성공되었습니다.");
		} else {
			System.out.println("결과: 계좌가 존재하지 않습니다.");
		}
	}

	@Override
	public void withdraw(Account[] accountArray) {
		System.out.println("-----------");
		System.out.println("출금");
		System.out.println("-----------");

		System.out.print("계좌번호: ");
		String findAno = sc.nextLine();
		System.out.print("예금액: ");
		int wdBalance = Integer.parseInt(sc.nextLine());

		Account depoArr = findAccount(findAno, accountArray);

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

	@Override
	public Account findAccount(String ano, Account[] accountArray) {
		Account account = null;

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				String accountStr = accountArray[i].getAno();
				if (accountStr.equals(ano)) {
					account = accountArray[i];
					break;
				}
			}
		}
		return account;
	}

}
