package ch10_oop.sec02_constructor;

public class Student extends Person {
	int studentId;
	
	public Student(String name, int age, int studentId) {
		super(name, age);
		this.studentId = studentId; 
	}
	
	void study() {
		System.out.println(name + " 이/가 공부를 합니다.");
		
	}
}
