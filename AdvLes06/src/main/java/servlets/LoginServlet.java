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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userDao = new UserServiceImpl();
    	MagazineServiceImpl magazineDao = new MagazineServiceImpl();
    	
		String userName = request.getParameter("username");
		String pass = request.getParameter("password");
				try {
			if ( pass.equals(userDao.thisUser(userName).getPassword())) {
				
				request.setAttribute("userName", userName);
				request.setAttribute("list", magazineDao.readAll());
				User user = userDao.thisUser(userName);
				request.setAttribute("mylist", userDao.userSubscribes(user));
				request.getRequestDispatcher("myCabinet.jsp").forward(request, response);
							}
			else  request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
	}

}
