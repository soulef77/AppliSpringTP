package fr.inetum.formation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/converter")
public class ConverterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Pages/converter.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String valeur =  req.getParameter("valeurTemp");
		
		
		try { double valeurInt = Double.parseDouble(valeur);
			
			double nb = ((9 * valeurInt)/5) +32;
			req.setAttribute("valeurTemp",nb);
			System.out.println(" valeur "+ nb);
		} catch (NumberFormatException e) {
			req.setAttribute("erreur", "attention à votre saisie");
		}
				
		
		doGet(req, resp);
		
	}
	
	
}
