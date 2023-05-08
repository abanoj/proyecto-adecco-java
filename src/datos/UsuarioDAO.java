package datos;

import java.sql.*;
import java.util.*;

import domain.Conexion;
import domain.Usuario;

public class UsuarioDAO {

	private static final String SELECT_SQL = "SELECT * FROM proyecto.usuarios";
	private static final String INSERT_SQL = "INSERT INTO usuarios (`dni`, `nombre`, `apellido`, `usuario`, `contrasena`, `tipo`, `activo`) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String UPDATE_PASS_SQL = "UPDATE usuarios SET `contrasena` = ? WHERE (`id` = ?);";
	private static final String DELETE_SQL = "DELETE FROM usuarios WHERE (`id` = ?);";
	
	
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
				int tipo = rs.getInt("tipo");
				boolean activo = rs.getBoolean("activo");
				
				usuario = new Usuario(id, dni, nombre, apellido, user, contrasena, tipo, activo);
				usuarios.add(usuario);
			}
			
			System.out.println("+====================Lista de usuarios====================+");
			
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
	
	public void insert(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(INSERT_SQL);
			ps.setString(1, usuario.getDni());
			ps.setString(2, usuario.getNombre());
			ps.setString(3, usuario.getApellido());
			ps.setString(4, usuario.getUser());
			ps.setString(5, usuario.getContrasena());
			ps.setInt(6, usuario.getTipo());
			ps.setBoolean(7, usuario.isActivo());

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
	
	public void updatePassword(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(UPDATE_PASS_SQL);
			ps.setString(1, usuario.getContrasena());
			ps.setInt(2, usuario.getId());
			
			ps.execute();
			System.out.println("Update Password Success!");			
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
	
	public void delete(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(DELETE_SQL);
			ps.setInt(1, usuario.getId());
			
			ps.execute();
			System.out.println("Delete User Success!");
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
