package ch09_modifier.sec03_static;

public class SampleMain {

	public static void main(String[] args) {
		// 인스턴스 필드, 메소드를 사용하는 방법
		Sample s = new Sample();
		System.out.println(s.instanceField);
		s.instanceMethod();
		
		// 스태틱 필드, 메소드를 사용하는 방법
//		System.out.println(s.STATIC_FIELD);
//		s.staticMethod();
	}

}
