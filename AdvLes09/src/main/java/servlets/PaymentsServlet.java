package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Magazine;
import domain.Payments;
import domain.User;
import service.Impl.MagazineServiceImpl;
import service.Impl.PaymentsServiceImpl;
import service.Impl.UserServiceImpl;


@WebServlet("/payments")
public class PaymentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		String productId = request.getParameter("productId");
		
		MagazineServiceImpl magazineService = new  MagazineServiceImpl();
		Magazine mag = magazineService.read(Integer.parseInt(productId));
		
		UserServiceImpl userService = new UserServiceImpl();
		User user = userService.read(userId);
		PaymentsServiceImpl paymentsService = new PaymentsServiceImpl();
		
		Payments payment = new Payments(new Date(), user.getUser_name(),mag.getName(),mag.getPrice() );
		paymentsService.create(payment);
		
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
