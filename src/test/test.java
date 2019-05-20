package test;

import org.apache.ibatis.session.SqlSession;

import dao.CustomerMapper;
import pojo.Customer;
import pojo.CustomerDemo;
import service.CustomerService;
import service.CustomerServiceImpl;
import util.MybatisUtils;

public class test {

	public static void main(String[] args) throws Exception {
//		CustomerService cs = new CustomerServiceImpl();
//		List<Customer> l = cs.queryById(1, "男");
//		System.out.println(l.get(0));
		
		
//		CustomerDemo cd =new CustomerDemo();
//		Customer c = new Customer();
//		c.setCid(1);
//		c.setGender("男");
//		cd.setCustomer(c);
//		SqlSession  sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
//		CustomerMapper  CM = sqlSession.getMapper(CustomerMapper.class);
//		c = (Customer) CM.queryById(cd);
//		System.out.println(c);
		
//		SqlSession  sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
//		CustomerMapper  CM = sqlSession.getMapper(CustomerMapper.class);			 
//			 System.out.println(CM.queryAll());
		
		
//		SqlSession  sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
//		CustomerMapper  CM = sqlSession.getMapper(CustomerMapper.class);
		CustomerService cs = new CustomerServiceImpl();
		CustomerDemo cd = new CustomerDemo();
		Customer c = new Customer();
//		c.setCid(9);
//		c.setCname("小紫");
		c.setGender("女");
//		c.setBirthday("2012-11-1");
//		c.setCellphone("13388990099");
//		c.setEmail("23134222@qq.com");
//		c.setDescription("撒旦范德萨范德萨分");
		cd.setCustomer(c);
		System.out.println(cs.queryDuo(cd));;
	}

}
