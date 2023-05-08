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
		
		usuarios = usuarioDao.select();
		
		usuarios.forEach( el -> System.out.println(el));
	}

}
