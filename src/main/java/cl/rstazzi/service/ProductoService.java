package cl.rstazzi.service;

import java.util.List;

import cl.rstazzi.dao.ProductoDaoImp;
import cl.rstazzi.interfaces.ProductoDao;
import cl.rstazzi.model.Producto;

public class ProductoService {
	
	private ProductoDao productoDao = new ProductoDaoImp();

	public Producto buscarProducto(int id) {
			return productoDao.buscarProducto(id);
	}
	
	public List<Producto> listarProductos(){
		return productoDao.listarProductos();

	}
	
    public Producto agregarProducto(Producto producto) {
		return productoDao.agregarProducto(producto);

	}
	
	public Producto modificarProducto(Producto producto) {
		return productoDao.modificarProducto(producto);

	}
	
	public boolean eliminarProducto(int id) {
		return productoDao.eliminarProducto(id);

	}
	
	public int obtenerUltimoId() {
		return productoDao.obtenerUltimoId();

	}
	
}
