package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import domain.Payments;
import service.Impl.PaymentsServiceImpl;

@WebServlet("/buckets")
public class Buckets extends HttpServlet {
	 
	
	private static final long serialVersionUID = -4505403585870869896L;
	private	PaymentsServiceImpl bucketService = new PaymentsServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("userName");
		List<Payments> buckets = bucketService.userPayments(name);
		
		
		String json = new Gson().toJson(buckets);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	
	
}
