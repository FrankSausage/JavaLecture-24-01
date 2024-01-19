package ch10_oop.sec02_constructor;

public class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name; this.age = age;
	}
	public void eat() {
		System.out.println(name + " 이/가 맛있게 식사를 합니다.");
	}
	public void sleep() {
		System.out.println(name + " 이/가 꿀잠을 잡니다.");
	}
}
