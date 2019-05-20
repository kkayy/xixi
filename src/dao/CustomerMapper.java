package dao;

import java.util.List;

import pojo.Customer;
import pojo.CustomerDemo;

public interface CustomerMapper {
	/**
	 * 
	 *添加用户
	 * @param c 
	 * @return 
	 */
	int add (Customer c);
	/**
	 * 删除用户
	 */
	int del();
	/**
	 * 修改用户
	 */
/**
 * 高级查询
 * @param cd 查询条件
 * @return
 */
	//Customer queryById(CustomerDemo cd);
/**
 * 查询所有人	
 * @return
 */
	List<Customer> queryAll();
	/**
	 * 根据cid查询信息
	 * @param cid
	 * @return
	 */
	Customer queryById(int cid);
	/**
	 * 根据cid修改用户信息
	 * @param c
	 * @return
	 */
	int edit(CustomerDemo c) throws Exception;
	/**
	 * 根据用户id删除用户
	 * @param cid
	 * @return
	 */
	int deleteById(int cid);
	/**
	 * 根据条件查找用户
	 * @param cs
	 * @return
	 */
	List<Customer> queryDuo(CustomerDemo c); 
}
