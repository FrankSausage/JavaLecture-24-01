package ch04_control;

import java.time.LocalDate;
import java.util.Scanner;

public class Ex03_FullAge {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
//		System.out.println(today);				// 2024-01-16
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
//		System.out.printf("%d, %d, %d%n", year, month, day);	// 2024, 1, 16
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("생년> ");
		int bYear = Integer.parseInt(scan.nextLine());
		System.out.printf("생월> ");
		int bMonth = Integer.parseInt(scan.nextLine());		
		System.out.printf("생일> ");
		int bDay = Integer.parseInt(scan.nextLine());
		scan.close();

		if(month > bMonth || (bMonth == month && bDay <= day)) {
			System.out.println("나이는 만" + (year - bYear) + "세 입니다.");
		}
		else {
			System.out.println("나이는 만 " + (year - bYear - 1) + "세 입니다.");
		}
	}

}
