package utils;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;




public class MySQLConexion {
	//Coneccion a la Base de Datos
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/login";
	private static final String USUARIO = "root";
	private static final String CLAVE = "Dalmichui02";

	public static Connection getConexion() {
		
		try {
			
			Class.forName(CONTROLADOR);
			
			
			Connection con = DriverManager.getConnection(URL, USUARIO, CLAVE);
			return con;
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!");
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD");
		}
		return null;
		
	}
}
