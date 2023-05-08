package datos;

import java.sql.*;
import java.util.*;

import domain.Conexion;
import domain.Usuario;

public class UsuarioDAO {

	private static final String SELECT_SQL = "SELECT * FROM proyecto.usuarios";
	private static final String INSERT_SQL = "";
	private static final String UPDATE_SQL = "";
	private static final String DELETE_SQL = "";
	
	
	public List<Usuario> select(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SELECT_SQL);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String dni = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String user = rs.getString("usuario");
				String contrasena = rs.getString("contrasena");
				int tipo = rs.getInt("tipo_usuario");
				boolean activo = rs.getBoolean("activo");
				
				usuario = new Usuario(id, dni, nombre, apellido, user, contrasena, tipo, activo);
				usuarios.add(usuario);
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
		
		
		return usuarios;
	}
}
