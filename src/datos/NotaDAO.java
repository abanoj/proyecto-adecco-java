package datos;

import java.sql.*;
import java.util.*;

import domain.Conexion;
import domain.Nota;

public class NotaDAO {

	private static final String SQL_SELECT_ONE = "SELECT nota FROM notas WHERE id_alumno = ? AND id_asignatura = ? AND id_curso = ?";
	private static final String SQL_SELECT_CURSO = "SELECT id_asignatura, nota FROM notas WHERE id_alumno = ? AND id_curso = ?;";
	private static final String SQL_INSERT = "INSERT INTO notas(id_alumno, id_asignatura, id_curso, nota) VALUES(?, ?, ?, ?);";

	public Map<Integer, Float> select(int idAlumno, int idCurso) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<Integer, Float> lista = new HashMap<Integer, Float>();
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_SELECT_CURSO);
			ps.setInt(1, idAlumno);
			ps.setInt(2, idCurso);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				int idA = rs.getInt("id_asignatura");
				float nota = rs.getFloat("nota");
				lista.put(idA, nota);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	
	public float select(Nota n) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		float nota = 0f;
		
		try {
			conn = Conexion.obtenerConexion();
			ps = conn.prepareStatement(SQL_SELECT_ONE);
			ps.setInt(1, n.getIdAlumno());
			ps.setInt(2, n.getIdAsignatura());
			ps.setInt(3, n.getIdCurso());

			rs = ps.executeQuery();
			
			if(rs.next()) {
				nota = rs.getFloat("nota");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return nota;
	}
	
	public void insert(Nota nota) {
		
	}
	
}
