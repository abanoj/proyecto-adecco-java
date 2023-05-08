package test;

import java.util.*;

import domain.*;
import datos.UsuarioDAO;

public class TestUsuario {

	public static void main(String[] args) {
		List<Usuario> usuarios;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
//		Usuario alumno = new Alumno("0012381S", "Maria", "Ramos", "mariar12", "a1b2c3", false);
//		Usuario profesor = new Profesor("Y8180092G", "Pedro", "Estevez", "pedroes", "pGsg20$5", true);
		
		//Insert
//		usuarioDao.insert(alumno);
//		usuarioDao.insert(profesor);
		
		//Update
//		Usuario proferor = new Profesor(4, "otracontra123");
//		usuarioDao.updatePassword(proferor);

		//Delete
//		Usuario usuario = new Usuario(4);
//		usuarioDao.delete(usuario);
		
		//Select
//		usuarios = usuarioDao.select();		
//		usuarios.forEach( el -> System.out.println(el));
	}

	public static void usuariosAleatorios(int n) {
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			String DNI = generarDNI();
			String nombre = generarNombre();
			String apellido = generarNombre();
			String username = nombre.charAt(0) + apellido.toLowerCase();
			String password = username.substring(0,2) + "$" + nombre.substring(0,2) + DNI.substring(0,3);
			int tipo = random.nextInt(2) + 1;
			boolean activo = random.nextBoolean();
		}
		
	}
	/*
	 * Generador de nombres aleatorios de entre tres y siete caracteres
	 */
	public static String generarNombre() {
		String vocales = "aeiou";
		String consonantes = "bcdfghjklmnpqrstvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int longitud = random.nextInt(5) + 3;
        boolean isVocal = random.nextBoolean();
        
		for(int i = 0; i < longitud; i++) {
			if(i==0) {
				if(isVocal) {
					sb.append(Character.toUpperCase(vocales.charAt(random.nextInt(vocales.length()))));									
				} else {
					sb.append(Character.toUpperCase(consonantes.charAt(random.nextInt(vocales.length()))));
				}
			} else {
				if(isVocal) {
					sb.append(vocales.charAt(random.nextInt(vocales.length())));
				} else {
					sb.append(consonantes.charAt(random.nextInt(consonantes.length())));
				}				
			}
			isVocal = !isVocal;
		}
		return sb.toString();
	}
	
	public static String generarDNI() {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 8; i++) {
			sb.append(random.nextInt(10));
		}
		char letra = letras.charAt(random.nextInt(letras.length()));
		return sb.toString() + letra;
	}
}
