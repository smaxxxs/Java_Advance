package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Magazine;
import service.Impl.MagazineServiceImpl;


@WebServlet("/CRUDMagazineServlet")
public class CRUDMagazineServlet extends HttpServlet {
	MagazineServiceImpl magazineService = new MagazineServiceImpl();
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		Magazine mag = new Magazine(name,getValidatedPrice(price));
		System.out.println("new Magazine created");
		magazineService.create(mag);
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
	
	private float getValidatedPrice(String price) {
		if(price == null || price.isEmpty()) {
			return 0;
		}
		return Float.parseFloat(price);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doDelete(req, resp);
	}


	

}
