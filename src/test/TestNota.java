package test;

import java.util.Map;

import datos.*;
import domain.*;

public class TestNota {

	public static void main(String[] args) {
		NotaDAO notaDao = new NotaDAO();
		AsignaturaDAO asignaturaDao = new AsignaturaDAO();
		
		Usuario usuario = new Usuario(1);
		Curso curso = new Curso(1);
		
		Map <Integer, Float> notasA1 = notaDao.select(usuario, curso);
		
		for (Integer key : notasA1.keySet()) {
			System.out.println(asignaturaDao.selectName(key) + ": " + notasA1.get(key));
		}
		
	}

}
