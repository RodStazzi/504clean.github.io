package cl.rstazzi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.rstazzi.model.Categoria;
import cl.rstazzi.model.Producto;
import cl.rstazzi.service.CategoriaService;
import cl.rstazzi.service.ProductoService;

@WebServlet("/modificarProductoController")
public class ModificarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private ProductoService productoService = new ProductoService();
private CategoriaService categoriaService = new CategoriaService();


    public ModificarProductoController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		if (id <= 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);			
		}
		Producto producto = productoService.buscarProducto(id);
		System.out.println(producto);
		List<Categoria> categorias = categoriaService.listarCategorias();		
		
		request.setAttribute("producto", producto);
		request.setAttribute("categorias", categorias);
		
		request.getRequestDispatcher("modificarproducto.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int precio = Integer.parseInt(request.getParameter("precio"));
		int categoria = Integer.parseInt(request.getParameter("categoria"));

		if (id <= 0) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}

		Producto producto = new Producto(id, nombre, descripcion, precio, categoria);
		Producto productoModificado = productoService.modificarProducto(producto);

		if (productoModificado == null) {
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}

//		Producto producto = new Producto();
//		producto.setId(id);
//		producto.setNombre(nombre);
//		producto.setPrecio(precio);
//		producto.setDescripcion(descripcion);
//		producto.setIdCategoria(categoria);
//		
//		producto.update(producto);
		
		request.getRequestDispatcher("listarProductoController").forward(request, response);
	}

}
