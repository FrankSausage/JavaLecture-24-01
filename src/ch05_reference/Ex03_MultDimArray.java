package ch05_reference;

import java.util.Arrays;

public class Ex03_MultDimArray {

	public static void main(String[] args) {
		// 2차원 배열(matrix)
//		int[][] matrix = new int[2][3];
		int score[][] = { { 80, 80, 70 }, { 85, 88, 72 } };
		System.out.println(Arrays.toString(score)); // 출력되지 않음
		System.out.println(Arrays.toString(score[0]));
		System.out.println(Arrays.toString(score[1]));

		// 인덱싱
		System.out.println(score[0][0] + ", " + score[1][1]);

		// 톱니바퀴 모양도 가능
//		int[][] gear = { { 1, 3, 5, 9 }, { 2, 6 }, { 8, 5, 3 } };

		// 실력향상 연습문제
		// 두 행렬의 dot product 구해보기
//		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };		// 2 x 3
//		int[][] b = { { 1, 2 }, { 3, 4 }, { 5, 6 } };	// 3 x 2
//		int[][] c = new int[2][2];

		// 지뢰찾기
//		char[][] mines = new char[8][8];
//		for (int i = 0; i < mines.length; i++) {
//			for (int k = 0; k < mines[i].length; k++) {
//				mines[i][k] = (Math.random() > 0.7) ? '*' : '.';
//			}
//		}
//		printMines(mines);

		char[][] padMines = new char[10][10];
		char[][] finalMines = new char[8][8];
		for (int i = 0; i < padMines.length; i++) {
			for (int k = 0; k < padMines[i].length; k++) {
				padMines[i][k] = (Math.random() > 0.7) ? '*' : '.';
			}
		}
		int count = 0;
		for (int i = 0; i < finalMines.length; i++) {
			for (int k = 0; k < finalMines[i].length; k++) {
				if (padMines[i][k] == '.') {
					count = 0;
					for (int x = -1; x < x + 2; x++) {
						for (int y = -1; y < y + 2; y++) {
							if (padMines[i-x][y] == '*') {
								count++;
							}
							continue;
						}
					}
				}
			}
			System.out.println(count);
		}
		printMines(padMines);
		System.out.println();
//		printMines(finalMines);

	}

	static void printMines(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int k = 0; k < arr[i].length; k++) {
				System.out.print(arr[i][k] + " ");
			}
			System.out.println();
		}
	}

}
