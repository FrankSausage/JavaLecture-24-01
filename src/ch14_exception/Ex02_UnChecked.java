package ch14_exception;

public class Ex02_UnChecked {
	
	public static void main(String[] args) {
		try {
			System.out.println(3 / 0);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		
		int[] intArray = new int[3];
		try {
			System.out.println(intArray[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		String str = null;
		try {
			System.out.println(str.length());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		str = "100원";
		try {
			int val = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		Animal a1 = new Cat();
		Animal a2 = new Dog();
		Animal cat = null;
		try {
			cat = (Cat) a2;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램의 마지막입니다.");
		
		
	}
}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}
