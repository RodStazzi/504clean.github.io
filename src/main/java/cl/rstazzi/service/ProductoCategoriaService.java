package cl.rstazzi.service;

import java.util.List;

import cl.rstazzi.dao.ProductoCategoriaDaoImp;
import cl.rstazzi.dto.ProductoCategoria;
import cl.rstazzi.interfaces.ProductoCategoriaDao;

public class ProductoCategoriaService {

	private ProductoCategoriaDao productoCategoriaDao = new ProductoCategoriaDaoImp();
	public List<ProductoCategoria> listarProductosCategoria(){
		
		return productoCategoriaDao.listarProductosCategoria();
		
	}

	
}
