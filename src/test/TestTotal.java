package test;

import java.util.*;

import domain.*;
import datos.*;

public class TestTotal {

	public static void main(String[] args) {
		//obtenerInicio(1,2);
		//obtenerAlumnos(3);
		addNotas(3);
	}

	public static void obtenerInicio(int idU, int idC) {
		AsignaturaDAO aDAO = new AsignaturaDAO();
		UsuarioDAO uDAO = new UsuarioDAO();
		CursoDAO cDAO = new CursoDAO();
		NotaDAO nDAO = new NotaDAO();
		Map<Integer,Float> notas = nDAO.select(idU, idC);
		Float promedio = 0f;
		
		Usuario usuario = uDAO.select(idU);
		
		Curso curso = cDAO.select(idC);
		
		System.out.println("");
		System.out.println("+======================================================+");
		System.out.println("Nombre: " + usuario.getNombre() + " " + usuario.getApellido());
		System.out.println("Curso: " + curso.getNombre());
		System.out.println("Asignaturas - Notas");
		
		if(notas.isEmpty()) {
			System.out.println("El alumno no está inscrito en este curso");
		} else {
			for (Integer key : notas.keySet()) {
				System.out.println(aDAO.selectName(key) + ": " + notas.get(key));
				promedio += notas.get(key);
			}
			promedio /= notas.size();
			System.out.println("Su promedio de notas en el curso es: " + promedio);			
		}

	}
	
	public static void obtenerAlumnos(int idC) {
		CursoDAO cDAO = new CursoDAO();
		NotaDAO nDAO = new NotaDAO();
		
		Curso curso = cDAO.select(idC);
		List<Nota> notas = nDAO.select(curso);
		if(notas.isEmpty()) {
			System.out.println("No hay notas registradas");
			return;
		}
		ArrayList<Integer> idAs = new ArrayList<>();
		
		for (int i = 0; i < notas.size(); i++) {
			idAs.add(notas.get(i).getIdAlumno());
		}
		Set<Integer> aux = new HashSet<>(idAs);
		idAs.clear();
		idAs.addAll(aux);		
		
		for (Integer i : aux) {
			obtenerInicio(i, idC);
		}
	}
	
	public static void addNotas(int n) {
		final int CANT_ASIGNATURAS = 11;
		Nota nota;
		NotaDAO nDAO = new NotaDAO();
		Random random = new Random();
		float notita;
		for (int i = 0; i < n; i++) {
			int idA = random.nextInt(CANT_ASIGNATURAS) + 1;
			int idU;
			Usuario user;
			UsuarioDAO uDAO = new UsuarioDAO();
			
			do {
				idU = random.nextInt(300) + 10;
				user = uDAO.select(idU);
			} while (user.getTipo() == 2);
			
			
			int idC = random.nextInt(2) + 1;
			nota = new Nota(idU, idA, idC);
			nDAO.insert(nota);			
		}
	}
	
}
