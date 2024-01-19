package ch10_oop.sec02_constructor;

public class Main {

	public static void main(String[] args) {
		Person p = new Person("제임스", 27);
		p.eat(); p.sleep();
		
		Student s = new Student("마리아", 23, 1234);
		s.eat(); s.sleep(); s.study();
	}
}
