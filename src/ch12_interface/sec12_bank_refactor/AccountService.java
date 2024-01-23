package ch12_interface.sec12_bank_refactor;

public interface AccountService {
	int DELETED = 1;			// public static final 이 생략 
	
	void createAccount();		// public abstract 가 생략
	
	void accountList();
	
	void deposit();
	
	void withdraw();
	
	void delete();
	
	Account findAccount (String ano);
}
