package test;

import java.util.Map;

import datos.*;

public class TestNota {

	public static void main(String[] args) {
		NotaDAO notaDao = new NotaDAO();
		AsignaturaDAO asignaturaDao = new AsignaturaDAO();
				
		Map <Integer, Float> notasA1 = notaDao.select(1, 1);
		System.out.println(notasA1);
		
		for (Integer key : notasA1.keySet()) {
			System.out.println(asignaturaDao.selectName(key) + ": " + notasA1.get(key));
		}
		
	}

}
