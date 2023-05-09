package test;

import java.util.List;

import datos.AsignaturaDAO;
import domain.Asignatura;

public class TestAsignatura {

	public static void main(String[] args) {
		AsignaturaDAO asignaturaDao = new AsignaturaDAO();
		List<Asignatura> asignaturas = asignaturaDao.select();		
		asignaturas.forEach(el -> System.out.println(el));

		//Insert
//		Asignatura asignatura = new Asignatura("Educación Física", 49);
//		System.out.println(asignatura.getIdProfesor2());
//		asignaturaDao.insert(asignatura);
		
		//Select
		asignaturas = asignaturaDao.select();
		asignaturas.forEach(el -> System.out.println(el));
		
	}

}
