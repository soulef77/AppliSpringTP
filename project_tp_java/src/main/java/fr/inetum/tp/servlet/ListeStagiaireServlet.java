package fr.inetum.tp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import fr.inetum.tp.entites.Stagiaire;
import fr.inetum.tp.services.IStagiaireService;
import fr.inetum.tp.services.StagiaireService;




@WebServlet("/liste")
public class ListeStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IStagiaireService service;
    
    @Override
    public void init() throws ServletException {
    	service = new StagiaireService();
    }
    	
	
    public ListeStagiaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*Set<Stagiaire> stagiaires= new HashSet<>();
		try {
			stagiaires = service.AllStagiaires();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("stagiaires", stagiaires);
		
		req.getRequestDispatcher("WEB-INF/Pages/listeStagiaire.jsp").forward(req, resp);*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action= req.getParameter("action");
		String id =  req.getParameter("id");
		System.out.println(" ACTION " + action);
		if((action != null) && action.equals("supprimer") && Integer.parseInt(id) != 0) {
			System.out.println(" ID "+ id);
			try {
				service.deleteStagiaire(Integer.parseInt(id));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
}
