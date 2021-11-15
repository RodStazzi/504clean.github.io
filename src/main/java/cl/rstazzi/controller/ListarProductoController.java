package cl.rstazzi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.rstazzi.dao.ProductoCategoriaDaoImp;
import cl.rstazzi.dto.ProductoCategoria;
import cl.rstazzi.interfaces.ProductoCategoriaDao;
import cl.rstazzi.service.ProductoCategoriaService;

@WebServlet("/listarProductoController")
public class ListarProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private ProductoCategoriaService productoCategoriaService = new ProductoCategoriaService();
    public ListarProductoController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//	    ProductoCategoriaDao productoCategoriaDao = new ProductoCategoriaDaoImp();

		List<ProductoCategoria> listaProductosCategorias = productoCategoriaService.listarProductosCategoria();
		System.out.println(listaProductosCategorias);
		request.setAttribute("productos", listaProductosCategorias);
		request.getRequestDispatcher("listarproductos.jsp").forward(request, response);

	}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
}

}
