package ch04_control;

public class Ex04_Switch {

		public static void main(String[] args) {
			String s = "Hello";
			System.out.println(s.equals("hello"));
			
			switch(s) {
			case "Hello":
				System.out.println(true); break;
			case "hello":
				System.out.println("대소문자 구분"); break;
			default:
				System.out.println(false);
			}
		}
}
