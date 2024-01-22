package ch10_oop.sec05_equals;

import java.util.Objects;

public class Customer {
	private int cid;
	private String name;
	private int age;
	private boolean adult;
	
	public Customer() {}
	public Customer(int cid, String name, int age, boolean adult) {
		super();
		this.cid = cid;
		this.name = name;
		this.age = age;
		this.adult = adult;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.cid, this.age);
//		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Customer) {
//			Customer customer = (Customer) obj;
//			// cid 값만 같으면 동일한 객체
//			return this.cid == ((Customer)obj).getCid();
			// cid 값과 name이 같아야 동일한 객체
//			return customer.getCid() == cid && customer.getName().equals(name);
			return this.cid == ((Customer)obj).getCid() 
					&& this.name.equals(((Customer)obj).getName());
		}
		return super.equals(obj);
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", age=" + age + ", adult=" + adult + "]";
	}
	
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
