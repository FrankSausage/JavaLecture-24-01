package ch14_exception;

public class Ex07_General {

	public static void main(String[] args) {
		int val = 0;
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			val = Integer.parseInt(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("사용법 : 매개변수가 필요하고 숫자를 입력해야 합니다.");
		}
		System.out.println(val);
	}


}
