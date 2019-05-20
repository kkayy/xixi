package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Customer;
import pojo.CustomerDemo;
import service.CustomerService;
import service.CustomerServiceImpl;


@WebServlet("/QueryDuoServlet")
public class QueryDuoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		CustomerDemo cd =new CustomerDemo();
		Customer c = new Customer();
		c.setCname(request.getParameter("cname"));
		c.setGender(request.getParameter("gender"));
		c.setCellphone(request.getParameter("cellphone"));
		c.setEmail(request.getParameter("email"));
		cd.setCustomer(c);
		CustomerService cs =new CustomerServiceImpl();
		List<Customer> customer =  cs.queryDuo(cd);
		if(customer!=null) {
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		}
		else {
			response.getWriter().println("<script language='javascript'>alert('失败');location.href=\"/customer/query.jsp\"</script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
