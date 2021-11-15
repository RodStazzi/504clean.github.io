package cl.rstazzi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jpath.example.Person;

import cl.rstazzi.dao.ProductoDaoImp;
import cl.rstazzi.interfaces.ProductoDao;



@WebServlet("/eliminarProductoController")
public class EliminarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EliminarProductoController() {
        super();
    }

	private ProductoDaoImp productoDao = new ProductoDaoImp();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		int id = Integer.parseInt(request.getParameter("id"));
		
//		PersonaRepository personaRepository = new Person();//instancia de PersonaRepository para acceder a los m�todos del DAO
		ProductoDao productoDao = new ProductoDaoImp();
		String idParam = request.getParameter("id");

		if (idParam == null || idParam.isEmpty()) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}

		request.setAttribute("id", idParam);
		request.getRequestDispatcher("eliminarproducto.jsp").forward(request, response);

	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idParam = request.getParameter("id");
		int id = 0;
		
		if (idParam == null || idParam.isEmpty()) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}

		id = Integer.parseInt(idParam);
		productoDao.eliminarProducto(id);

		request.getRequestDispatcher("listarProductoController").forward(request, response);

	}

}
