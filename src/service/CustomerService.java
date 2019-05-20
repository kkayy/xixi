package service;

import java.util.List;

import pojo.Customer;
import pojo.CustomerDemo;

public interface CustomerService {

	boolean add(Customer c);

	Customer queryById(int cid);
	
	List<Customer> queryAll();

	boolean edit(CustomerDemo c);
	
	boolean deleteById(int cid);

	List<Customer> queryDuo(CustomerDemo c);
}
