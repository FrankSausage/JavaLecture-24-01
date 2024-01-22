package ch12_interface.sec04_dao;

import java.util.List;

public class MainWithoutInterface {

	public static void main(String[] args) {
		// MySQL DB를 사용하려면
		CustomerDaoMySQLImpl cdSQL = new CustomerDaoMySQLImpl();
		Customer customer = cdSQL.getCustomer(34);
		List<Customer> list =cdSQL.getCustomerList();
		cdSQL.insertCustomer(customer);
		cdSQL.updateCustomer(customer);
		cdSQL.deleteCustomer(34);
		
		// Oracle DB를 사용하려면
		CustomerDaoOracleImpl cdOracle = new CustomerDaoOracleImpl();
		customer = cdOracle.getCustomer(34);
		list = cdOracle.getCustomerList();
		cdOracle.insertCustomer(customer);
		cdOracle.updateCustomer(customer);
		cdOracle.deleteCustomer(34);
		
	}

}
