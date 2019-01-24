package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.Impl.MagazineServiceImpl;


@WebServlet("/magazine")
public class MagazineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MagazineServiceImpl magazineService = new MagazineServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<domain.Magazine> magazines = magazineService.readAll();
		String json = new Gson().toJson(magazines);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}


}
