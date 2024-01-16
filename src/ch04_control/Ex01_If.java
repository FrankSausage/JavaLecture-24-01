package ch04_control;

public class Ex01_If {

	public static void main(String[] args) {
		int score = 60 + (int)(41 * Math.random());		// 60 ~ 100
		
		if (score >= 80) {
			System.out.println(score + "점은 평균 이상입니다");
		}
		else {
			System.out.println(score + "점은 평균 미만입니다");
		}
		
		char grade;
		if (score >= 90) {
			grade = 'A';
		}
		else if (score >= 80) {
			grade = 'B';
		}
		else if (score >= 70) {
			grade = 'C';
		}
		else {
			grade = 'D';
		}
		System.out.println("score: " + score + " , grade: " + grade);
	}
}
