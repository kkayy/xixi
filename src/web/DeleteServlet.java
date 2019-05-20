package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;
import service.CustomerServiceImpl;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		int cid = Integer.parseInt(request.getParameter("id"));
		CustomerService cs =new  CustomerServiceImpl();
		if(cs.deleteById(cid)) {
			response.getWriter().println("<script language='javascript'>alert('成功');location.href=\"/customer/msg.jsp\"</script>");
		}else {
			response.getWriter().println("<script language='javascript'>alert('失败');location.href=\"/customer/list.jsp\"</script>");

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
