package test;

import java.util.List;

import datos.AsignaturaDAO;
import domain.Asignatura;

public class TestAsignatura {

	public static void main(String[] args) {
		AsignaturaDAO asignaturaDao = new AsignaturaDAO();
		List<Asignatura> asignaturas = asignaturaDao.select();
		
		asignaturas.forEach(el -> System.out.println(el));
		
	}

}
