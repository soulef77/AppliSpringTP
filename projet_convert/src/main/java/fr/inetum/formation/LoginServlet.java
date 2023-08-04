package fr.inetum.formation;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/Pages/Login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email= req.getParameter("email");
		String mdp= req.getParameter("mdp");
		
		/*System.out.println(String.format("Email: %s && Mdp %s", email, mdp));*/
		
		if(email.equals("stagiaire@inetum.fr") && mdp.equals("123")) {
			 User user = new User(email,mdp);
			 
			req.getSession().setAttribute("user", user);
			
			//le user est reconnu et eccède à la page converteer.jsp
			resp.sendRedirect("converter");
		}else {
			resp.sendRedirect("login");
		}
	}


}
