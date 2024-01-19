package ch10_oop.sec03_override;

public class Main {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.parentField = 1000;
		p.parentMethod();
		
		
		Child c = new Child();
		c.childField = 300;
		c.parentField = 600;
		c.childMethod();
		c.parentMethod();
		
//		Parent pc = new Child();
//		Child cp = (Child) new Parent();
	}

}
