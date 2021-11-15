<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet">
<script src="js/script.js"></script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="login-reg-panel">
		<div class="login-info-box">
			<h3>Have an account?</h3>
			<p>Lorem ipsum dolor sit amet</p>
			<label id="label-register" for="log-reg-show">Login</label> <input
				type="radio" name="active-log-panel" id="log-reg-show"
				checked="checked">
		</div>

		<div class="register-info-box mx-5 p-5 ">
			<h3>¿No tienes cuenta?</h3>
			<h2>Haz click en el botón</h2>
			<label id="label-login" class="btn btn-outline-dark" for="log-login-show">Registrarse</label><input
				type="radio" name="active-log-panel" id="log-login-show"> 

		</div>

		<div class="white-panel">
			<div class="login-show">
				<h3>ACCESO</h3>
				<!--  				<input type="text" placeholder="Email"> <input
					type="password" placeholder="Password"> <input
					type="button" value="Login"> <a href="">Forgot
					password?</a> -->

				<form action="procesaLogin" method="POST">
					<!-- la accion indica hacia donde se enviara la información -->
					<input type="text" id="login" class="fadeIn second" name="login"
						placeholder="Usuario"> <input type="password" id="password"
						class="fadeIn third" name="pass" placeholder="Contraseña"> 
				<input
						type="submit" class="fadeIn fourth btn btn-outline-success btn-lg btn3d" value="Iniciar Sesión"><span class="glyphicon glyphicon-ok">
				</form>

				<div class="contaniner-fluid bg-pink text-center p-4 ">
					<img src="img/504Clean.svg" alt="" width="256" height="157">

				</div>
				<p class="display-5 font-weight-bold my-3 fs-5 text-center">
					by <img src="./img/ro.sta.negro.svg" alt="" width="90px"
						height="30px"> © 2021.
				</p>
			</div>

			<div class="register-show">
				<h2>REGISTER</h2>
				<input type="text" placeholder="Email" > <input
					type="password" placeholder="Password"> <input
					type="password" placeholder="Confirm Password"> <input
					type="button" value="Register">
			</div>
		</div>
	</div>

	<!-- <footer class="contaniner-fluid mt-auto bg-pink text-center p-3"> -->
		<footer class="mt-auto">
        	<p class="display-5 font-weight-bold my-6 fs-5 text-center"> 
			by <img src="./img/ro.sta.negro.svg" alt="" width="150px"
				height="50px"> © 2021. 
		</p>
	</footer>
</body>
</html>