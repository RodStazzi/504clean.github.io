<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
        <title>Limpieza</title>
    </head>
    <body>
 <nav class="navbar navbar-expand-lg bg-verde text-white" style="background-color: rgba(171, 235, 198, 1)">
      <div class="container-fluid">
      <a class="navbar-brand" href="#">
        <img src="/img/504CleanTitle.png" alt="" width="100" height= auto><img src="/img/504Clean2.png" alt="" width="59" height= auto
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
	       <p class="display-5 font-weight-bold my-6 fs-6 text-center"></p>
            <h4>AGREGAR PRODUCTO</h4>
      		<div class="dropdown-divider"> </div>
        
        <div class="container mt-2 p-6">
      <form action="agregarProductoController" method = "POST">
        <div class="mb-3">
          <label for="nombreProducto" class="form-label" name="nombre">Nombre Producto</label>
          <input class="form-control" id="nombreProducto" name="nombre" type="text">
        </div>
        <div class="mb-3">
          <label for="descripcion" class="form-label" name="descripcion">Descripción</label>
          <input class="form-control" id="descripcion" name="descripcion" type="text">
        </div>
        <div class="mb-3">
          <label for="precio" class="form-label" name="precio">Precio</label>
          <input class="form-control" id="precio" name="precio" type="text">
        </div>
        
        <div class="mb-3">
          <label for="categoria">Categoría</label> <select name="categoria">
						<c:forEach items="${categorias}" var="cat">
							<option value="${cat.getId()}">${cat.getNombre()}</option>
						</c:forEach>
					</select>
        </div>
       
        <button type="submit" class="btn btn-outline-success shadow">Agregar</button>
      </form>
    </div>
    	</div>
    
    		<footer class="contaniner-fluid bg-pink text-center p-3">

		<p class="display-5 font-weight-bold my-20 fs-6 text-center">
			by <img src="./img/ro.sta.negro.svg"  alt="" width="100px"
				height="50px"> © 2021.
		</p>
	</footer>
    
    </body>
</html>