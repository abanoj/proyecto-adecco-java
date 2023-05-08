package domain;

import java.util.ArrayList;

public class Curso {

	private int id;
	private String nombre;
	private ArrayList<Integer> idA;
	
	public Curso() {}

	public Curso(int id) {
		this.id = id;
	}

	public Curso(String nombre, ArrayList<Integer> idA) {
		this.nombre = nombre;
		this.idA = idA;
	}

	public Curso(int id, String nombre, ArrayList<Integer> idA) {
		this.id = id;
		this.nombre = nombre;
		this.idA = idA;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Integer> getIdA() {
		return idA;
	}

	public void setIdA(ArrayList<Integer> idA) {
		this.idA = idA;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", idA=" + idA + "]";
	}	
	
	
}
