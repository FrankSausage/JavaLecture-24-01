package ch05_reference;

import java.util.Arrays;

//import java.util.Scanner;

public class Ex12_StringMethod {

	public static void main(String[] args) {
		String str1 = "Hello Java";
		String str2 = "안녕하세요? 반갑습니다.";
		
		/* 스트링의 길이 - 속성(X) 메소드(O) */
		System.out.println(str1.length() + ", " + str2.length());		// 10, 13
		
		/* 문자열 검색 */
		System.out.println(str2.charAt(0) + ", " + str2.charAt(7));		// 안, 반
		
		// 주민등록번호를 입력받아서 남자인지 여자인지 구분
//		Scanner sc = new Scanner(System.in);
//		System.out.print("주민등록번호 입력> ");
//		String gender = sc.nextLine();
//		
//		switch(gender.charAt(7)) {
//		case '1': case '3':
//			System.out.println("남자"); break;
//		case '2': case '4':
//			System.out.println("여자"); break;
//		}
		
		// 찾고자 하는 문자열이 대상 문자열에 있는지 확인
		System.out.println(str1.indexOf("Java") + ", " + str2.indexOf('반'));
		
		if(str1.toLowerCase().indexOf("java") >= 0){
			System.out.println("문장 안에 java라는 글자가 있습니다.");
		}
		
		System.out.println("apple pineapple".lastIndexOf("pp"));
		
		
		/* 문자열 변환 */
		boolean a = true; int b = 123; double c = 3.14; char d = 'a';
		
		// 명시적(explicit) 변환
		System.out.println(String.valueOf(a) + ", " + String.valueOf(b) + ", " 
							+  String.valueOf(c) + ", " + String.valueOf(d));
		// 암묵적(implicit) 변환
		System.out.println(a + ", " + b + ", " + c + ", " + d);

		/* 문자열 배열 변환, 문자열 => byte[], char[] */
		byte[] byteStr1 = str1.getBytes();
		byte[] byteStr2 = str2.getBytes();
		System.out.println(Arrays.toString(byteStr1));
		System.out.println(Arrays.toString(byteStr2));		// utf-8 = 초성 + 중성 + 종성 각 1 byte
		System.out.println(Arrays.toString(str2.toCharArray()));
		
		/* 문자열 내용 비교 */
		System.out.println(str1.equals("Hello java"));		// 문자열 비교시 == 사용X
		System.out.println(str1.equalsIgnoreCase("hello java")); // 대소문자 구분X
		
		
	}

}
