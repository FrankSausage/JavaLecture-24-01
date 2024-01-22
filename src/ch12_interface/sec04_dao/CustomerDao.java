package ch12_interface.sec04_dao;

import java.util.*;

// DAO (Data Access Object) - DB를 Access 하기 위한 코드
public interface CustomerDao {
	
	Customer getCustomer(int cid);
	
	List<Customer> getCustomerList();
	
	void insertCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(int cid);
}
