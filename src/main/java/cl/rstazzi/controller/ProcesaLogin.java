package cl.rstazzi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcesaLogin
 */
@WebServlet("/procesaLogin")
public class ProcesaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private final String LOGIN = "Admin"; //user fake
	private final String PASS = "admin"; //password fake


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String requestLogin = "";
		String requestPass = "";
		
		PrintWriter out = response.getWriter();
		
		requestLogin = request.getParameter("login");
		requestPass = request.getParameter("pass");

		if (!LOGIN.contentEquals(requestLogin) || !PASS.contentEquals(requestPass)) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('usuario o pasword incorrecto');");
			out.println("location='login.jsp';");
			out.println("</script>");
			
		} else {
			HttpSession sesionUsuario = request.getSession(true);
			sesionUsuario.setAttribute("nombre", requestLogin);
			RequestDispatcher rd = request.getRequestDispatcher("listarproductos.jsp");
			rd.forward(request, response);
		}
		
	}

}




