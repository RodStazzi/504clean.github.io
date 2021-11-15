package cl.rstazzi.interfaces;

import java.util.List;

import cl.rstazzi.model.Categoria;
import cl.rstazzi.model.Producto;

public interface ProductoDao {

	public Producto buscarProducto(int id);
	public List<Producto> listarProductos();
	public Producto agregarProducto(Producto producto);
	public Producto modificarProducto(Producto producto);
	public boolean eliminarProducto(int id);
	public int obtenerUltimoId();

	public List<Producto> findAll();
	public Producto findById(int id);
	public boolean add(Producto producto);
	public boolean update(Producto producto);
	public boolean delete(int id);
	
}
