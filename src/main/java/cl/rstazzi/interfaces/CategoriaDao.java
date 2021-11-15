package cl.rstazzi.interfaces;

import java.util.List;

import cl.rstazzi.model.Categoria;

public interface CategoriaDao {

	public Categoria buscarCategoria(int id);
	public List<Categoria> listarCategorias();
	
}
