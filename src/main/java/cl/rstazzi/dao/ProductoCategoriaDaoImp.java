package cl.rstazzi.dao;

import java.util.ArrayList;
import java.util.List;

import cl.rstazzi.dto.ProductoCategoria;
import cl.rstazzi.interfaces.CategoriaDao;
import cl.rstazzi.interfaces.ProductoCategoriaDao;
import cl.rstazzi.interfaces.ProductoDao;
import cl.rstazzi.model.Categoria;
import cl.rstazzi.model.Producto;

public class ProductoCategoriaDaoImp implements ProductoCategoriaDao{

	private ProductoDao productoDao = new ProductoDaoImp();
	private CategoriaDao categoriaDao = new CategoriaDaoImp();
	
	@Override
	public List<ProductoCategoria> listarProductosCategoria() {
		
		List <ProductoCategoria> listaProductoCategoria = new ArrayList<ProductoCategoria>();
		List <Producto> productos = productoDao.listarProductos();
		
		for (Producto productoTemp : productos) {
			
			ProductoCategoria productoCategoria = new ProductoCategoria();
		
			Categoria categoria = categoriaDao.buscarCategoria(productoTemp.getIdCategoria());
			productoCategoria.setProducto(productoTemp);
			productoCategoria.setCategoria(categoria);
			
			listaProductoCategoria.add(productoCategoria);
			
		}
		
		return listaProductoCategoria;
	}

}
