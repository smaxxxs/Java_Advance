package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import domain.User;
import dto.UserLogin;
import service.Impl.UserServiceImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userDao = new UserServiceImpl();
   // 	MagazineServiceImpl magazineDao = new MagazineServiceImpl();
    	
		String userName = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println(userName+pass);
				try {
					
			if ( pass.equals(userDao.thisUser(userName).getPassword())) {
				
			
				UserLogin userLogin = new UserLogin();
				User user = userDao.thisUser(userName);
				System.out.println(user+pass+"******************");
				HttpSession session = request.getSession();
				session.setAttribute("userId", user.getUser_id());
				session.setAttribute("userName", user.getUser_name());
				
				userLogin.destinationUrl = "myCabinet.jsp";
				userLogin.userName = user.getUser_name();;
				String json = new Gson().toJson(userLogin);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(json);
				
//				request.setAttribute("userName", userName);
//				request.setAttribute("list", magazineDao.readAll());
//				User user = userDao.thisUser(userName);
//				request.setAttribute("mylist", userDao.userSubscribes(user));
//				request.getRequestDispatcher("myCabinet.jsp").forward(request, response);
							}
			else  request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
	}

}
