package ch06_class.sec03_calculator;

public class CalculatorMain {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		int x = 3, y = 4;
		System.out.println("3 + 4 = " + cal.add(x, y));
		System.out.println("3 - 4 = " + cal.sub(x, y));
		System.out.println("3 * 4 = " + cal.mul(x, y));
		System.out.println("3 / 4 = " + cal.div(x, y));
		
		cal.print(30, 40);

		System.out.println("3.1 + 4.5 = " + cal.add(3.1, 4.5));
	}

}
