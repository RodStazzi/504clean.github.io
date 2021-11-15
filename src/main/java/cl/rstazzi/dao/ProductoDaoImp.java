package cl.rstazzi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.rstazzi.conexion.AdministradorConexion;
import cl.rstazzi.interfaces.ProductoDao;
import cl.rstazzi.model.Categoria;
import cl.rstazzi.model.Producto;

public class ProductoDaoImp extends AdministradorConexion implements ProductoDao{

	public ProductoDaoImp() {
		conn = generaConexion();
	}
	
	@Override
	public Producto buscarProducto(int id) {

		String query = "SELECT * FROM producto WHERE id_producto = ?";
		Producto producto = new Producto();

		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				producto.setId(rs.getInt("id_producto"));
				producto.setNombre(rs.getString("nombre_producto"));// getter es para obtener.. el setter es para dar valor 
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
			}
			return producto;
		} catch (SQLException e) {
				e.printStackTrace();
				return new Producto();
     }
	}
	
	@Override
	public List<Producto> listarProductos() {
		
		String query = "SELECT * FROM producto";
		List<Producto> listaProductos = new ArrayList<Producto>();

		try {
//			pstm = conn.prepareStatement(query);
//			rs = pstm.executeQuery();
//			
//			while (rs.next()) {
//				Producto producto = new Producto();
//				producto.setId(rs.getInt("id_producto"));
//				producto.setNombre(rs.getString("nombre_producto"));
//				producto.setDescripcion(rs.getString("descripcion_producto"));
//				producto.setPrecio(rs.getInt("precio_producto"));
//				producto.setIdCategoria(rs.getInt("id_categoria"));
//				listaProductos.add(producto);
//				
//			}
////			return listaProductos;
//		} catch (SQLException e) {
//			e.printStackTrace();
////			return new ArrayList<Producto>();
//		}
//		return listaProductos;
			pstm = conn.prepareStatement(query);//preparando la query a ejecuta		
			rs = pstm.executeQuery();//ejecucion de la query
			
			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id_producto"));//el paréntesis es el nombre de columna en mysql
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setDescripcion(rs.getString("descripcion_producto"));
				producto.setPrecio(rs.getInt("precio_producto"));
				producto.setIdCategoria(rs.getInt("id_categoria"));
				
				listaProductos.add(producto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaProductos;

	}
	
	@Override
	public Producto agregarProducto(Producto producto) {
		String query = "INSERT INTO producto (id_producto, nombre_producto, precio_producto, descripcion_producto, id_categoria) VALUES (?,?,?,?,?)";
		
		try {
			pstm = conn.prepareStatement(query);
					
			pstm.setInt(1, 0);
			pstm.setString(2, producto.getNombre());
			pstm.setInt(3, producto.getPrecio());
			pstm.setString(4, producto.getDescripcion());
			pstm.setInt(5, producto.getIdCategoria());
			
			int result = pstm.executeUpdate();
			
			if (result == 1) {
				return producto;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return producto;
	}
	
	@Override
	public Producto modificarProducto(Producto producto) {

		String query = "UPDATE producto SET nombre_producto = ?, descripcion_producto = ?," + "precio_producto = ?, id_categoria = ? WHERE id_producto = ?";
		
		try {
			pstm = conn.prepareStatement(query);
			
			pstm.setString(1, producto.getNombre());
			pstm.setString(2, producto.getDescripcion());
			pstm.setInt(3, producto.getPrecio());
			pstm.setInt(4, producto.getIdCategoria());
			pstm.setInt(5, producto.getId());
			
			int result = pstm.executeUpdate();
			
			if (result == 1) {
				return producto;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Producto();
	}
	
	@Override
	public boolean eliminarProducto(int id) {
		
		String query = "DELETE FROM producto WHERE id_producto = ?;";
		
		try {
			
			pstm = conn.prepareStatement(query);
			
			pstm.setInt(1, id);
			
			int result = pstm.executeUpdate();
			
			if (result == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return false;
	}
	@Override
	public int obtenerUltimoId() {
		
		int resultado = -1;
		
		String query = "SELECT MAX(id_producto) AS max_id FROM producto";
		
		try {
			
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				resultado = rs.getInt("max_id");
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			return resultado;
		}
		
	}

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
