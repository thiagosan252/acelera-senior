package net.atos.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.atos.model.User;
import net.atos.persistencia.LoginDAO;
import net.atos.persistencia.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session=request.getSession();  
		if (LoginDAO.executaLogin(username, password)) {
	        session.setAttribute("status","sucesso");  
	        
	        User user = UserDAO.buscarUsuario(username);
	        if(user != null) {
	        	 session.setAttribute("name", user.getName()); 
	        	 request.getRequestDispatcher("index.jsp").include(request, response);  
	        } else {
	        	session.setAttribute("status","erroUsuario");  
				response.sendRedirect("login.jsp");
	        }
	        
			
		} else {
			session.setAttribute("status","erro");  
			response.sendRedirect("login.jsp");
		}

	}

}
