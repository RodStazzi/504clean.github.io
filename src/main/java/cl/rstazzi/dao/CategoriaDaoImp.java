package cl.rstazzi.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.rstazzi.conexion.AdministradorConexion;
import cl.rstazzi.interfaces.CategoriaDao;
import cl.rstazzi.model.Categoria;

public class CategoriaDaoImp extends AdministradorConexion implements CategoriaDao {

	public CategoriaDaoImp() {
		conn = generaConexion();
	}
	
	@Override
	public Categoria buscarCategoria(int id) {

		String query = "SELECT * FROM categoria WHERE id_categoria = ?";
		Categoria categoria = new Categoria();
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			if (rs.next()) {
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));// getter es para obtener.. el setter es para dar valor 
			}
			return categoria;
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
     }
		
		
}


	@Override
	public List<Categoria> listarCategorias() {
		String query = "SELECT * FROM categoria";
		List <Categoria> listaCategorias = new ArrayList<Categoria>();
		try {
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
		
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setNombre(rs.getString("nombre_categoria"));
				listaCategorias.add(categoria);
			}
			return listaCategorias;
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
		}
	}

//	@Override
//	public List<Categoria> listarCategorias() {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
