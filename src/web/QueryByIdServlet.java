package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;


@WebServlet("/QueryByIdServlet")
public class QueryByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int cid = Integer.parseInt(request.getParameter("id"));
		CustomerService cs =new  CustomerServiceImpl();
		Customer c =cs.queryById(cid);
		if(c!=null) {
			request.setAttribute("customer", c);
			request.getRequestDispatcher("/edit.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
