package service;

import java.util.List;

import dao.CustomerMapper;
import pojo.Customer;
import pojo.CustomerDemo;
import util.OpenSessionInViewUtils;

public class CustomerServiceImpl implements CustomerService {
	private CustomerMapper cm;
	public boolean add(Customer c) {
		cm = OpenSessionInViewUtils.get().getMapper(CustomerMapper.class);
		int i = cm.add(c);
		if(i==1) {
			return true;
		}
		return false;
	}
	@Override
	public Customer queryById(int cid) {
		cm = OpenSessionInViewUtils.get().getMapper(CustomerMapper.class);
		System.out.println(cm.queryById(cid));
		return cm.queryById(cid);
	}
	public List<Customer> queryAll(){
		cm = OpenSessionInViewUtils.get().getMapper(CustomerMapper.class);
		return cm.queryAll();	
	}
	
	@Override
	public boolean edit(CustomerDemo c) {
		cm = OpenSessionInViewUtils.get().getMapper(CustomerMapper.class);
		System.out.println(1);
		int no=0;
		try {
			no = cm.edit(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(no == 1) {
			OpenSessionInViewUtils.get().commit();
			System.out.println(4);
			return true;
		}
		System.out.println(5);
		return false;
	}
	@Override
	public boolean deleteById(int cid) {
		cm = OpenSessionInViewUtils.get().getMapper(CustomerMapper.class);
		return (cm.deleteById(cid)>0);
	}
	@Override
	public List<Customer> queryDuo(CustomerDemo c) {
		cm = OpenSessionInViewUtils.get().getMapper(CustomerMapper.class);
		return (cm.queryDuo(c));
	}
	
	
}
