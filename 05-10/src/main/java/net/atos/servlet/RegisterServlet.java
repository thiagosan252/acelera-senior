package net.atos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.atos.model.User;
import net.atos.persistencia.LoginDAO;
import net.atos.persistencia.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		String password = request.getParameter("pass");
		String rePassword = request.getParameter("re_pass");

		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setContact(request.getParameter("contact"));

		RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");

		if(!password.equals(rePassword)) {
			request.setAttribute("status", "passwordFalha");
			request.setAttribute("name", user.getName());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("contact", user.getContact());
			request.setAttribute("pass", password);
			request.setAttribute("re_pass", rePassword);
		} else {
			Long userId = UserDAO.cadastrarUsuario(user);

			if (userId > 0 && userId != null && LoginDAO.cadastrarLogin(userId, user.getEmail(), password)) {
				request.setAttribute("status", "sucesso");
			} else {
				request.setAttribute("status", "falha");
			}
		}

		dispatcher.forward(request, response);

	}

}
