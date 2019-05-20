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

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String cname=request.getParameter("cname");
		String gender=request.getParameter("gender");
		String  birthday = request.getParameter("birthday");
		String cellphone = request.getParameter("cellphone");
		String email = request.getParameter("email");
		String description = request.getParameter("description");
		Customer c = new Customer();
		c.setCname(cname);
		c.setGender(gender);
		c.setBirthday(birthday);
		c.setCellphone(cellphone);
		c.setEmail(email);
		c.setDescription(description);
		CustomerService cs = new CustomerServiceImpl();
		if(cs.add(c)) {
			response.getWriter().println("<script language='javascript'>alert('成功');location.href=\"/customer/add.jsp\"</script>");
		}else {
			response.getWriter().println("<script language='javascript'>alert('失败');location.href=\"/customer/add.jsp\"</script>");

		}
		;
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
