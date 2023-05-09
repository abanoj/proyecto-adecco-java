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
//		asignaturaDao.insert(asignatura);

		//Update
//		Asignatura asignatura = asignaturaDao.select(18);
//		asignatura.setIdProfesor1(399);
//		asignaturaDao.update(asignatura);

		//Delete
//		Asignatura asignatura = new Asignatura(17);
//		asignaturaDao.delete(asignatura);
		
		//Select
//		asignaturas = asignaturaDao.select();
//		asignaturas.forEach(el -> System.out.println(el));
		
		
	}

}
