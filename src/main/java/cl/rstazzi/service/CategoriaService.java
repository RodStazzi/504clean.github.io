package cl.rstazzi.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.rstazzi.dao.CategoriaDaoImp;
import cl.rstazzi.interfaces.CategoriaDao;
import cl.rstazzi.model.Categoria;

public class CategoriaService {

	private CategoriaDao categoriaDao = new CategoriaDaoImp();
	
	
	public Categoria buscarCategoria(int id) {

		return categoriaDao.buscarCategoria(id);
		
}
	
	public List<Categoria> listarCategorias() {

		return categoriaDao.listarCategorias();

	}	
	
	
}
