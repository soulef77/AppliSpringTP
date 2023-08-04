package fr.inetum.formation.mvc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/autre")
public class AutreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Je suis dans le do Get de AutreServlet ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prenom= request.getParameter("prenom");
		 request.setAttribute("prenom",prenom);
		String age= request.getParameter("age");
		 request.setAttribute("age",age);
	/*esponse.getWriter().append("Je suis dans le do post de AutreServlet ").append("\nMon prenom est " + prenom).append("mon age est :" + age);*/
		
		request.getRequestDispatcher("/WEB-INF/pages/Autrejsp.jsp").forward(request, response); 
	}

}
