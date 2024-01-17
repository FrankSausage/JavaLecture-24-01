package ch05_reference;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Ex13_StringMethod2 {

	public static void main(String[] args) {
		String str1 = "Hello Java";
		String str2 = "안녕하세요? 반갑습니다.";
		
		/* 대소문자 변경 */
		System.out.println(str1.toUpperCase());
		System.out.println(str1.toLowerCase());
		
		/* 문자열 대치(replace) */
		String str3 = str2.replace("안녕하세요", "안녕").replace("반갑습니다", "방가방가");
		System.out.println(str3);		// 안녕? 방가방가.
		System.out.println(str3.replace("방가", "하이"));
		
		// 정규표현식 사용 가능
		String regExp = str2.replaceAll("[?.]", "*"); 	// ? 또는 . 을 * 로 변경
		System.out.println(regExp);
		
		/* 문자열 일부 발췌 */
		String dateTime = "2024-01-17 14:20:05";
		String date = dateTime.substring(0, 10);
		String time = dateTime.substring(11);
		System.out.println(date + ", " + time);
		
		String now = LocalDateTime.now().toString();
		System.out.println(now); 			// 2024-01-17T14:25:16.595370200
		date = now.substring(0, 10);
		time = now.substring(11, 11+8);
		System.out.println(date + ", " + time);
		
		// 주민등록번호로 부터 생년월일(yyyy-mm-dd) 표시하기
		String ssn1 = "880927-1234567", ssn2 = "010117-4123456";
		
		System.out.println(ymdPrinter(ssn1));
		System.out.println(ymdPrinter(ssn2));
		
		
		/* 문자열을 분할해서 배열로 반환 */
		String fruitStr = "감, 배, 귤, 밤";
		String[] fruits = fruitStr.split(", ");
		System.out.println(Arrays.toString(fruits));
		
		fruitStr = "감, 배; 귤: 밤";
		fruits = fruitStr.split("[,;:] ");			// 정규 표현식 사용가능
		System.out.println(Arrays.toString(fruits));
		
		// PATH
		String pathStr = "C:\\Program Files\\Common Files\\Oracle\\Java\\javapath;C:\\Program Files\\Common Files\\microsoft shared;C:\\Program Files\\Bandizip;C:\\Program Files\\Git";
		String[] pathArray = pathStr.split(";");
		for (String path: pathArray) {
			System.out.println(path.replace("\\", "/"));
		}
		
		/* 문자열 배열을 하나의 문자열로 생성 */
		System.out.println(String.join(" -:- ", "감, 배; 귤: 밤".split("[,;:] ")));
		
		/* 문자열 좌우의 공백 제거 */
		String diryText = " \t 자바 프로그래밍 	\t \r\n";
		String cleanText = diryText.trim();
		System.out.println(cleanText);
		
	}
	
	static String ymdPrinter(String txt) {
		String ymd = "";
		int txtIndex = txt.indexOf('-');
		String txtSplit = txt.substring(0, txtIndex);
		
		if (txtIndex + 1 == 1 || txtIndex + 1 == 2) {
			ymd = "19";
		}
		else {
			ymd = "20";
		}
		ymd += txtSplit.substring(0, 2) + "-" + txtSplit.substring(2,4) + "-" + txtSplit.substring(4,6);
		
		return ymd;
	}	
}
