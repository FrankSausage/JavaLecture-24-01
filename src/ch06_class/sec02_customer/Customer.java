package ch06_class.sec02_customer;

public class Customer {
	private int cid;
	private String name;
	private int age;
	private boolean adult;
	
	
	// 생성자(Constructor)
	public Customer() { }
	public Customer(int cid, String name, int age) {
//		this.cid = cid;
//		this.name = name;
//		this.age = age;
//		this.adult = age > 19 ? true : false ;
		this(cid, name, age, age > 19 ? true : false);
	}

	public Customer(int cid, String name, int age, boolean adult) {
		this.cid = cid;
		this.name = name;
		this.age = age;
		this.adult = adult;
	}
	
	// toString() method
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", age=" + age + ", adult=" + adult + "]";
	}
	
	// Getter / Setter method
	public int getCid() {
		return cid;
	}
	
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isAdult() {
		return adult;
	}
	
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	
	
}
