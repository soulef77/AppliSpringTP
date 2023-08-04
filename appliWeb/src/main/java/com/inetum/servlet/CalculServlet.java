package com.inetum.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CalculServlet")
public class CalculServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public CalculServlet() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out =  response.getWriter();
		String sX = request.getParameter("x");
		Double x = sX!=null?Double.parseDouble(sX):0;
		Double y = Math.sqrt(x);
		
		out.println("<html>");
		out.println("<body>");
		out.println("<form method= 'GET' acton='' >");
			out.println("x=<input type='text' name='x' />");
			out.println("<input type='submit' value='calculer racine carré' />");
		out.println("</form>");
		out.println("<hr/>");
		out.println("y="+y);
		out.println("</body>");
		out.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
