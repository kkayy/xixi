package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Customer;
import pojo.CustomerDemo;
import service.CustomerService;
import service.CustomerServiceImpl;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	int cid  =Integer.parseInt(request.getParameter("cid"))	;
	String cname  =request.getParameter("cname");
	String gender  =request.getParameter("gender");
	String birthday  =request.getParameter("birthday");
	birthday=birthday.substring(0,10); 
	String cellphone  =request.getParameter("cellphone");
	String email  =request.getParameter("email");
	String description  =request.getParameter("description");
	System.out.println(2);
//	CustomerDemo cd = new CustomerDemo();
//	Customer c = new Customer();
//	c.setCid(cid);
//	c.setCname(cname);
//	c.setGender(gender);
//	c.setBirthday(birthday);
//	c.setCellphone(cellphone);
//	c.setEmail(email);
//	c.setDescription(description);
//	cd.setCustomer(c);
//	CustomerService cs = new CustomerServiceImpl();
//	System.out.println(3);
//	System.out.println(cs.edit(cd));
///
	CustomerService cs = new CustomerServiceImpl();
	CustomerDemo cd = new CustomerDemo();
	Customer c = new Customer();
	c.setCid(cid);
	c.setCname(cname);
	c.setGender(gender);
	c.setBirthday(birthday);
	c.setCellphone(cellphone);
	c.setEmail(email);
	c.setDescription(description);
	cd.setCustomer(c);
	cs.edit(cd);
		if(cs.edit(cd)) {
			response.getWriter().println("<script language='javascript'>alert('成功');location.href=\"/customer/msg.jsp\"</script>");
		}else {
			response.getWriter().println("<script language='javascript'>alert('失败');location.href=\"/customer/edit.jsp\"</script>");

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
