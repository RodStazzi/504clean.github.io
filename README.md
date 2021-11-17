# 504clean.github.io

# Proyecto 504 Clean

Proyecto web dinámico utilizando el lenguaje Java, con solicitudes HTTP de una aplicación web dinámica con conexión a base de datos y capa de persistencia de la aplicación. 
Esta aplicación registra en Categorías diferentes productos de Aseo y Limpieza. Es capaz de registrar, mostrar, modificar y eliminar los productos siguiendo el patrón de diseño MVC configurando las librerías que utilizará el proyecto (JSTL y driver de conexión a base de datos). Para esto usa JSP y JSTL para desplegar datos de forma dinámica.
Utiliza Bootstrap para definir el layout de las vistas y estilizar y sigue el patrón Facade, para conectar las capas de acceso a datos y el controlador. Implementa un mecanismo de autenticación, que restringe el acceso a la página de bienvenida, solicitando nombre de usuario y contraseña y un mecanismo de cierre de sesión.

Librerías incluídas:<br>
jstl.jar<br>
jstl-impl.jar<br>
jstl-standard.jar<br>
mysql-connector-java-5.1.49.jar<br>
mysql-connector-java-5.1.49-bin.jar<br>
bootstrap@5.1.2<br>
jQuery 3.2.1<br>

### Pre-requisitos 📋
Proyecto generado bajo <br>
Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)<br>
Version: 2021-09 (4.21.0)<br>

Tomcat v9.0<br>
<br>
Base de Datos MySQL<br>
Base de Datos = "productos_limpieza";<br>
Driver = "com.mysql.jdbc.Driver";<br>
Url = "jdbc:mysql://localhost/empresa";<br>
<br>
Con 2 tablas:<br>
CREATE TABLE `categoria` (<br>
  `id_categoria` int NOT NULL,<br>
  `nombre_categoria` varchar(50) DEFAULT NULL,<br>
  PRIMARY KEY (`id_categoria`)<br>
)<br>
<br>
CREATE TABLE `producto` (<br>
  `id_producto` int NOT NULL AUTO_INCREMENT,<br>
  `nombre_producto` varchar(75) DEFAULT NULL,<br>
  `precio_producto` int DEFAULT NULL,<br>
  `descripcion_producto` varchar(200) DEFAULT NULL,<br>
  `id_categoria` int DEFAULT NULL,<br>
  PRIMARY KEY (`id_producto`),<br>
  KEY `id_categoria` (`id_categoria`),<br>
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id_categoria`)<br>
)<br>
<br>
La única ruta planteada desde web.xml es <br>   <welcome-file>login.jsp</welcome-file><br>
<br>
<br>
Se despliegan los métodos del controlador:<br>
/procesaLogin <br>
/listarProductoController<br>
/agregarProductoController<br>
/modificarProductoController<br>
/eliminarProductoController<br>

## Comenzando 🚀

*Tras generar las conexiones respectivas con las tablas en AdministracionConexion.java
Run As -> Run On Server y generar el 1er despliegue del proyecto.

Podrá Agregar productos, Editarlos, Eliminarlos y Listarlos segun muestra .Gif
<br>
<br>
![504Clean](https://user-images.githubusercontent.com/88750836/142129579-95d662ff-dafd-41a8-8b12-be357566353c.gif)<br>
## Autores ✒️

* **Rodolfo Stazzi S** - *Back & Front* - [<ro.sta>](https://github.com/RodStazzi)

---
