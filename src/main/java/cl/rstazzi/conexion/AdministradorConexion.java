package cl.rstazzi.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AdministradorConexion {

	
	protected static Connection conn;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;
	
	protected Connection generaConexion() {
		String user = "root";
		String password = "pr6102aeae";
		String baseDeDatos = "productos_limpieza";
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/empresa";
		
		if (conn==null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection("jdbc:mysql://localhost/"+baseDeDatos+"?user="+user+"&password="+password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Conexión establecida");
			return conn;
		} 
		
		return conn;

	}

}
	
	
	//EJEMPLO DE CONEXION SIN SINGLETON
//	protected Connection generaConexion() {
//		String user = "root";
//		String pwd = "pr6102aeae";
//		String baseDeDatos = "productos_limpieza";
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost/productos_limpieza";
//		
//		if (conn == null) {
//			try {
//				Class.forName(driver);
////				conn = DriverManager.getConnection(url, user, pwd);
////				 conn =
////				 DriverManager.getConnection("jdbc:mysql://localhost/inscripcioncursos?user="+user+"&pwd="+pwd);
//				conn = DriverManager.getConnection("jdbc:mysql://localhost/"+baseDeDatos+"?user="+user+"&pwd="+pwd);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			System.out.println("Conexion");
//			return conn;
//		} else {
//			System.out.println("unica conexion");
//			return conn;
//		}
//	}
//	
//	protected Connection generaPoolConexion() {
//		Context initContext;
//		
//		if (conn == null) {
//		try {
//			initContext = new InitialContext();
//			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/ConexionMySQL");
//			
//			try {
//				conn = ds.getConnection();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//		System.out.println("Conexion");
//		return conn;
//	}else {
//		System.out.println("unica conexion");
//		return conn;
//		}
//	}
//	
//}



