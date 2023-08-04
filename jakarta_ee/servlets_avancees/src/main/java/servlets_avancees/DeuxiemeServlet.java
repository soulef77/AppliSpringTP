package servlets_avancees;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deux")
public class DeuxiemeServlet extends HttpServlet {

	private static final long serialVersionUID = -6289510095248333095L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("je suis dans la méthode post");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("je suis dans la méthode get");
		
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out= resp.getWriter();
		
		try {
			//ici on construit la réponse
			out.println("<!DOCTYPE  html>");
			out.println("<html>"
					+ "<head>"
					+ "<meta charset=UTF-8/>"
					+ "<title>Deuxième servlet</title>"
					+ "</head>"
					+ "<body>"
					+ "<h1>petit hello de servlet avancée</h1>"
					+ "</body>"
					+ "</html>");
					
		} catch (Exception e) {
			out.close();
		}
	}
	

}
