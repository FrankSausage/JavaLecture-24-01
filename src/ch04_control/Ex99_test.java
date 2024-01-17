package ch04_control;

public class Ex99_test {

	public static void main(String[] args) {
		int score = 72;

		studentGrading(score);
		studentGradingSwitch(score);
		breakNContinue();
		sameFuntionForWhile();
		countingA();

	}

	static void studentGrading(int val) {
		if (val >= 80 && val < 90) {
			System.out.println("B학점");
		} else if (val >= 90) {
			System.out.println("A학점");
		} else if (val >= 70 && val < 80) {
			System.out.println("C학점");
		} else {
			System.out.println("F학점");
		}
	}

	static void studentGradingSwitch(int val) {
		switch (val / 10) {
		case 10:
			System.out.println("A학점");
			break;
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("F학점");

		}
	}

	static void breakNContinue() {
		for (int i = 0;; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}

			if (i > 10) {
				break;
			} else {
				continue;
			}
		}
	}

	static void sameFuntionForWhile() {
		int i = 10;

		while (i > 0) {
			System.out.println(i);

			if (i <= 0) {
				break;
			}
			i -= 2;
		}
	}

	static void countingA() {
		int a = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 2) {
					continue;
				}
				if (j == 1) {
					break;
				}
				a++;
			}
		}
		System.out.println("A가 출력된 횟수는: " + a);
	}
}
