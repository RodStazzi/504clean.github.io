<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
 <nav class="navbar navbar-expand-lg bg-verde text-white" style="background-color: rgba(171, 235, 198, 1)">
      <div class="container-fluid">
      <a class="navbar-brand" href="#">
        <img src="./img/504CleanTitle.png" alt="" width="100" height= auto><img src="./img/504Clean2.png" alt="" width="59" height= auto
          class="d-inline-block">
      </a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
				aria-controls="navbarNavAltMarkup" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<a class="nav-link active" aria-current="page" href="#">Home</a> <a
						class="nav-link" href="listarProductoController">Listar</a> <a
						class="nav-link" href="agregarProductoController">Agregar Nuevo</a> 
                    <a class="nav-link" href="cerrarSesionController">Cerrar Sesion</a>
				</div>
			</div>
		</div>
	</nav>
         <div class="container">
            <div class="col-lg-6">
            <p class="display-5 font-weight-bold my-6 fs-6 text-center"></p>
            <h4>MODIFICAR PRODUCTO</h4>
            <div class="dropdown-divider"> </div>
            
            <form action="modificarProductoController" method="POST">
            	<input type="hidden" name="id" value="${producto.getId()}">
                Nombre:<br>
                <input class="form-control" type="text" name="nombre" value="${producto.getNombre()}"><br>
                Descripcion: <br>
                <input class="form-control" type="text" name="descripcion" value="${producto.getDescripcion()}"><br>
                Precio: <br>
                <input class="form-control" type="text" name="precio" value="${producto.getPrecio()}"><br>
                Categoria: <br>
            <%--    <select name="id_categoria">
                	<c:forEach items="${categorias}" var="categoria"> 
                		<option value="${categoria.getId()}" ${categoria.getId() == producto.getCategoria() ? 'selected': ''}>
                			${categoria.getNombre()}</option>
                	</c:forEach>
                </select> --%>
                 <select name="categoria">
                	<c:forEach items="${categorias}" var="var">
                		<option value="${var.getId()}"  ${producto.getIdCategoria() == cat.getId() ? "selected" : ""}>
                			${var.getNombre()}
                		</option>
                	</c:forEach>
                </select>
                
                <input class="btn btn-outline-primary shadow" type="submit" name="accion" value="Actualizar">
	     		<a class="btn btn-outline-secondary shadow" href="listarProductoController">Volver</a>
            </form>
          </div>
        </div>
    </body>
</html>