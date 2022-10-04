package net.atos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExibeHtml
 */
@WebServlet("/ExibeHtml")
public class ExibeHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExibeHtml() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter output = response.getWriter();
		output.println("<!DOCTYPE html>");
		output.println("<html>");
		
		output.print("<head>");
		output.println("<meta charset=\"ISO-8859-1\">");
		output.println("<title>Sobre mim</title>");
		output.println("</head>");
		output.println("<body>");
		output.println("<h1>Nome: </h1>");
		output.println("<p1>Thiago Santana</p1>");
		
		output.println("<h2>Idade: </h2>");
		output.println("<p>23</p>");

		output.println("<h2>Email: </h2>");
		output.println("<p>thiago.2.santana@atos.net</p>");
				
		output.println("<h2>Como se enxerga daqui 5 anos dentro do universo java?</h2>");
		output.println("<p>Sênior</p>");
		
		output.println("</body>");
		output.println("</html>");
	}

}
