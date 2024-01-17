package ch05_reference;


public class Ex99_JavaStringTest {
	public static void main(String[] args) {
		/* 자바 String 연습 */

		// 1. 1에서 1000사이에 0은 몇 번, 1은 몇 번, ... 9는 몇 번 사용되었는가?
		numberCounting(1000);

		// 2. 00:00 ~ 23:59 하루동안 3이 표시되는 시간은 총 몇초인가?
		digitalClock();

		// 3. 두개의 세자리수를 곱해서 나온 결과가 palindrome일 때, 가장 큰 plaindrome 수와 어떤 수를 곱해서 나온 결과인가?
		divPalindrom();

		// 4. C:/Users/human-18/Desktop/WebProject/JS/ch07.표준내장객체/04.String연습.js 에서
		// 파일명(04.String연습.js)만 출력
		stringSelecter();
	}

	static void numberCounting(int num) {
		String numStr = "";

		for (int i = 1; i <= num; i++) {
			numStr += i;
		}
		for (int i = 0; i <= 9; i++){
			String regEX = "[^" + i +"]";
			System.out.printf("%d: %d", i, numStr.replaceAll(regEX, "").length());
			System.out.println();
		}
	}

	static void digitalClock() {
		int totalSec = 0;

		for (int h = 0; h <= 23; h++) {
			for (int m = 0; m <= 59; m++) {
				if (Math.floor(h / 10) == 3 || h % 10 == 3 || Math.floor(m / 10) == 3 || m % 10 == 3) {
					totalSec += 60;
				}
			}
		}
		System.out.println(totalSec);
	}

	static void divPalindrom() {
		int palSum = 0;	int palVal1 = 0; int palVal2 = 0;

		for (int i = 0; i <= 999; i++) {
			for (int y = 0; y <= 999; y++) {
				if (isPalindrom(i * y) && (i * y) >= palSum) {
					palSum = i * y;	palVal1 = i; palVal2 = y;
				}
			}
		}
		System.out.printf("%d * %d = %d", palVal1, palVal2, palSum);
		System.out.println();
	}

	static boolean isPalindrom(int num) {
		String palStr = String.valueOf(num);

		for (int i = 0; i < palStr.length() / 2; i++) {
			if (!(palStr.charAt(i) == palStr.charAt(palStr.length() - 1 - i))) {
				return false;
			}
		}
		return true;
	}

	static void stringSelecter() {
		String samepleText = "C:/Users/human-18/Desktop/WebProject/JS/ch07.표준내장객체/04.String연습.js";
		String pathArr[] = samepleText.split("/");

		System.out.println(pathArr[pathArr.length - 1]);
	}

}
