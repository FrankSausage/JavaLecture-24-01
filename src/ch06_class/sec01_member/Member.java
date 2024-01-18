package ch06_class.sec01_member;

import java.time.LocalDate;

public class Member {
	// 필드, 멤버 ,속성
	public String name;
	private LocalDate birthDay;
	private String email;
	
	// 생성자(Constructor)
	public Member() { }
	
	public Member(String name, LocalDate birthDay, String email) {
		this.name = name;
		this.birthDay = birthDay;
		this.email = email;
	}
	// 메소드(Method)
	public int getAge() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		int age = (month < birthDay.getMonthValue() || (month == birthDay.getMonthValue() && day < birthDay.getDayOfMonth()))
					? year - birthDay.getYear() -1 : year - birthDay.getYear();
		return age;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", birthDay=" + birthDay + ", email=" + email + ", age=" + getAge() + "]";
	}
	
	// 내부 클래스
	class InnerClass{
		
	}
	
}
// 외부 클래스
class ExternalClass{
	
}

