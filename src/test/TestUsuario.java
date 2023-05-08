package test;

import java.util.*;

import domain.*;
import datos.UsuarioDAO;

public class TestUsuario {

	public static void main(String[] args) {
//		List<Usuario> usuarios;
//		UsuarioDAO usuarioDao = new UsuarioDAO();
//		usuarios = usuarioDao.select();
//		
//		usuarios.forEach( el -> System.out.println(el));
		
		Usuario alumno = new Alumno("00523821F", "Juan", "Perez", "juanperez", "123abc", true);
		System.out.println(alumno);
		
		Usuario profesor = new Profesor("Y6168872G", "Rosa", "Perez", "rosapez", "prda20$5", true);
		System.out.println(profesor);
	}

}
