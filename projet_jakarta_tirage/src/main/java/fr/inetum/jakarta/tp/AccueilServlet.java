package fr.inetum.jakarta.tp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int nbreTentative= 0;
	long n = Math.round(Math.random()*10);
	String[] Historique = new String[nbreTentative];

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Pages/Accueil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String nbreString = request.getParameter("nbre");
		
		boolean again= true;
		String valider= request.getParameter("submit");
		System.out.println("nombre aléatoire "+ n+ " la valeur entrée "+ nbreString);
		
		if(valider.equals("Valider votre choix") && again) {
			
				System.out.println("nbre tentative " + nbreTentative);
				nbreTentative++;
				rechercheNbre(nbreTentative,again, n, nbreString,request, response);
				Historique[nbreTentative] = nbreString;
			
		}			
		request.setAttribute("nbreTentative",nbreTentative);
		Historique = new String[nbreTentative];
		doGet(request, response);
		
		
		String recommencer= request.getParameter("tout recommencer");
						
		
}
	
	public void rechercheNbre(int nbreTentative, boolean again, long n, String nbreString, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		
	if((nbreTentative <= 3) && again == true) {
			 
			
		try {   
				double nbre = Double.parseDouble(nbreString);
				
				if(nbre == n && again) {
					request.setAttribute("nbre", "vous avez trouvé la bonne valeure");
					again = false;
					
				}else { 
						again = false;
						request.setAttribute("nbre", "vous avez perdu");
						nbreTentative = 0;
				}
					if(nbre > n) {
									request.setAttribute("comment","entrer un nombre plus petit");
									request.setAttribute("nbre", "recommencer");
						} else { 	request.setAttribute("comment","entrer un nombre plus grand");
									request.setAttribute("nbre", "recommencer");
					}
			
				} catch (Exception e) {
					
				}
		
			
		}else { 
			again = false;
			request.setAttribute("nbre", "vous avez perdu");
			nbreTentative = 0;
			for (int i = 0; i < Historique.length; i++) {
				request.setAttribute("historique", Historique[i]);
			}
	}
	}
}


