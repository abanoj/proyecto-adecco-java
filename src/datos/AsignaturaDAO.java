package datos;

import java.sql.*;
import java.util.*;

import domain.Asignatura;
import domain.Conexion;

public class AsignaturaDAO {

	private static final String SELECT_SQL = "SELECT * FROM asignaturas";
	private static final String INSERT_SQL = "INSERT INTO asignaturas (nombre, id_profesor1, id_profesor2) VALUES (?, ?, ?)";
	private static final String UPDATE_SQL = "";
	private static final String DELETE_SQL = "";
	
	public List<Asignatura> select(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Asignatura asignatura = null;
		List<Asignatura> asignaturas = new ArrayList<>();
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_SQL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int idp1 = rs.getInt("id_profesor1");
				int idp2 = rs.getInt("id_profesor2");
				
				asignatura = new Asignatura(id, nombre, idp1, idp2);
				asignaturas.add(asignatura);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return asignaturas;
	}

	public void insert(Asignatura asignatura) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setString(1, asignatura.getNombre());
			ps.setInt(2, asignatura.getIdProfesor1());
			ps.setInt(3, asignatura.getIdProfesor2());
			
			ps.execute();
			System.out.println("Insert Success!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
