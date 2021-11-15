<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF"
	crossorigin="anonymous">
<title>Limpieza</title>
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
	<p class="display-5 font-weight-bold my-6 fs-6 text-center"></p>

		<h4>PRODUCTOS DISPONIBLES EN 504 CLEAN</h4>
		<div class="dropdown-divider"> </div>
		
		<a class="btn btn-outline-success shadow" href="agregarProductoController">Agregar
			Nuevo</a> <br> <br>
		<table class="table table-sm ">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">NOMBRE</th>
					<th class="text-center">DESCRIPCION</th>
					<th class="text-center">PRECIO</th>
					<th class="text-center">CATEGORIA</th>
					<th class="text-center">ACCIONES</th>

				</tr>
			</thead>

			<tbody>
				<c:if test="${productos.size() == 0}">
					<td colspan="6">No hay productos que mostrar</td>
				</c:if>

				<c:forEach items="${productos}" var="var">

					<tr>

						<td class="text-center"><c:out
								value="${var.getProducto().getId()}"></c:out>
						<td class="text-center"><c:out
								value="${var.getProducto().getNombre()}"></c:out>
						<td class="text-center"><c:out
								value="${var.getProducto().getDescripcion()}"></c:out>
						<td class="text-center"><c:out
								value="${var.getProducto().getPrecio()}"></c:out>
						<td class="text-center"><c:out
								value="${var.getCategoria().getNombre()}"></c:out>
						<td class="text-center"><a class="btn btn-outline-warning shadow"
							href="modificarProductoController?id=${var.getProducto().getId()}">Modificar</a>
							<a class="btn btn-outline-danger shadow"
							href="eliminarProductoController?id=${var.getProducto().getId()}">Eliminar</a>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

	</div>
	
		<footer class="contaniner-fluid bg-pink text-center p-3">

		<p class="display-5 font-weight-bold my-20 fs-6 text-center">
			by <img src="./img/ro.sta.negro.svg" alt="" width="100px"
				height="50px"> © 2021.
		</p>
	</footer>
</body>
</html>