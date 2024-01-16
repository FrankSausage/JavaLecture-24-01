package ch04_control;

import java.util.Scanner;

public class Ex05_Alram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("알람 시간 입력> ");
		int hour = scan.nextInt();
		System.out.print("알람 분 입력> ");
		int min = scan.nextInt();
//		int hour = Integer.parseInt(scan.nextLine());
//		int min = Integer.parseInt(scan.nextLine());
		scan.close();
		
		timeCal(hour, min);
	}
	
	private static void timeCal(int hour, int min) {
		min -= 45;
		
		if(min < 0 ) {
			hour--;
			min += 60;
			if(hour < 0) {
				hour = 23;
			}
		}	
		System.out.println("알람 예정 시각: " + hour + " : " + min);
	}

}
