package ch04_control;

import java.util.Scanner;

public class Ex14_PerfectNumber {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("완전수를 구할 값 입력> ");
		int getVal = scan.nextInt();
		scan.close();
		
		
		if(perfectCal(getVal) == getVal) {
			System.out.println("약수의 합:  " + perfectCal(getVal));
			System.out.println(getVal + "은 완전수 입니다.");
		}
		else {
			System.out.println(" 약수의 합:  " + perfectCal(getVal));
			System.out.println(getVal + "은 완전수가 아닙니다.");
		}
	}
	
	private static int perfectCal(int val) {
		int calVal = 0;
		for (int i = 1; i < val; i++) {
			if(val % i == 0) {
				calVal += i;
			}
		}
		
		return calVal;
	}
}
