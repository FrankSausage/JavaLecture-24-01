package ch04_control;

import java.util.Scanner;

public class Ex13_Diamond {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("라인수(홀수) 입력>  ");
		String inputStr = scan.nextLine();
		int num = Integer.parseInt(inputStr) / 2;
		scan.close();
		for (int i = 0; i <= num; i++) {
			for (int y = 1; y <= num - i; y++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = num - 1; i >= 0; i--) {
			for (int y = 1; y <= num - i; y++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= 2 * i + 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
