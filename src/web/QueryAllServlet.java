package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;


@WebServlet("/QueryAllServlet")
public class QueryAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("test/html;charset=UTf-8");
		CustomerService cs = new CustomerServiceImpl();
		List<Customer> customer = cs.queryAll();
		if(customer!=null) {
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		}
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
