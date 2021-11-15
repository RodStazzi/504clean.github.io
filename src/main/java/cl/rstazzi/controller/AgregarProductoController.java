package cl.rstazzi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.rstazzi.dao.CategoriaDaoImp;
import cl.rstazzi.dao.ProductoDaoImp;
import cl.rstazzi.interfaces.CategoriaDao;
import cl.rstazzi.interfaces.ProductoDao;
import cl.rstazzi.model.Categoria;
import cl.rstazzi.model.Producto;


@WebServlet("/agregarProductoController")
public class AgregarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AgregarProductoController() {
        super();

    }

	private ProductoDao productoDao = new ProductoDaoImp();

	private CategoriaDao categoriaDao = new CategoriaDaoImp();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Categoria> categorias = categoriaDao.listarCategorias();
		request.setAttribute("categorias", categorias);
		
		HttpSession sesion = request.getSession();
		String nombreUsuario = (String)sesion.getAttribute("nombre");
		sesion.setAttribute("nombre", nombreUsuario);
		
		request.getRequestDispatcher("agregarproductos.jsp").forward(request, response);	

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String nombreParam = request.getParameter("nombre");
		String descripcionParam = request.getParameter("descripcion");
		String precioParam = request.getParameter("precio");
		String categoriaParam = request.getParameter("categoria");

		int precio = Integer.parseInt(precioParam);
		int categoria = Integer.parseInt(categoriaParam);

		Producto producto = new Producto();

		int id = productoDao.obtenerUltimoId();
		System.out.println(id);
		if (id < 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
			return;
		}

		producto.setId(id+1);
		producto.setNombre(nombreParam);
		producto.setDescripcion(descripcionParam);
		producto.setPrecio(precio);
		producto.setIdCategoria(categoria);

		Producto productoResponse = productoDao.agregarProducto(producto);
		System.out.println(productoResponse);
		if (productoResponse.getId() == 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
			return;
		}
		
		
		HttpSession sesion = request.getSession();
		String nombreUsuario = (String)sesion.getAttribute("nombre");
		sesion.setAttribute("nombre", nombreUsuario);
		sesion.setAttribute("ultimoProducto", productoResponse);
			
		request.getRequestDispatcher("listarProductoController").forward(request, response);

		
	}

}
