package fr.inetum.formation.mvc;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jspserv")
public class MaServlete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        System.out.println("méthode GET via JSP");
        
        
        String prenom= request.getParameter("prenom");
        request.setAttribute("prenom",prenom);
        
        
        
        String msg= " Je suis un msg qui provient de la servlet MaServlete";
        request.setAttribute("msg", msg);
        
        LocalDate date = LocalDate.now();
        request.setAttribute("date", date);
        LocalDateTime heure= LocalDateTime.now();
        request.setAttribute("heure", heure);
        		

        // ON FAIT ICI TOUS LES TRAITEMENTS QUE L'ON SOUHAITE

        // A LA FIN, ON PASSERA LA MAIN A LA JSP

        request.getRequestDispatcher("/WEB-INF/pages/majsp.jsp").forward(request, response); 

    }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prenom= req.getParameter("prenom");
		String age= req.getParameter("age");
		System.out.println(String.format("prenom : %s ,age : %s", prenom, age));
	}

}
