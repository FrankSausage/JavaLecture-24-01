package ch10_oop.sec01_Person;

public class Main {

	public static void main(String[] args) {
		Person p = new Person();
		p.name = "제임스"; p.age = 27;
		p.eat(); p.sleep();
		
		Student s = new Student();
		s.name = "마리아"; s.age = 23; s.studentId = 123;
		s.eat(); s.sleep(); s.study();
		
		Worker w = new Worker();
		w.name = "브라이언"; w.age = 25; w.workerID = 456;
		w.eat(); w.sleep(); w.work();
	}

}
