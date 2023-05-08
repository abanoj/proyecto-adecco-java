package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String DB = "jdbc:mysql://localhost:3307/";
	private static final String TABLE = "proyecto";
	private static final String USER = "java";
	private static final String PASS = "Cavanilles2023";
	
	public static Connection obtenerConexion() throws SQLException {
		return DriverManager.getConnection(DB + TABLE, USER, PASS);
	}
	
}
