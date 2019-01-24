package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.Impl.MagazineServiceImpl;
import service.Impl.UserServiceImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegistrationServlet() {
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userDao = new UserServiceImpl();
    	MagazineServiceImpl magazineDao = new MagazineServiceImpl();
    	
		String userName = request.getParameter("usernamesignup");
		String pass = request.getParameter("passwordsignup");
		String passConf = request.getParameter("passwordsignup_confirm");
		try {
			if (!userDao.existUser(userName) && pass.equals(passConf)) {
				System.out.println("GOOOOD");
				userDao.create(new User(userName,"",pass));
				request.setAttribute("userName", userName);
				request.setAttribute("list", magazineDao.readAll().toString());
				request.setAttribute("mylist", "You haven't any subscribe"+userDao.thisUser(userName));
				request.getRequestDispatcher("myCabinet.jsp").forward(request, response);
							}
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
	
		
	}

}
