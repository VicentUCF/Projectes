package login;

import java.io.File;
import java.util.Scanner;

public class GestorUsuarios {

	static Scanner teclat = new Scanner(System.in);
	private final String nomFitxer;
	private final Creadorfitxeros fitxer;
	private final ListaUsuarios lista;

	public GestorUsuarios(String nomFitxer) {
		this.nomFitxer = nomFitxer;
		this.fitxer =  new Creadorfitxeros(nomFitxer);
		if(fitxer.getF().length()!=0){
			this.lista  = new ListaUsuarios(new File(nomFitxer));
		}else{
			this.lista = new ListaUsuarios();
		}

	}

	public void MenuPrincipal() {


		 boolean finalitzar = false;
		 
		 do {
			 
			 Menu();
			 switch(teclat.nextInt()){
			 case 1: {
			 	 lista.ListarUsuarios();
				 break; 
			 }
			 
			 
			 
			 case 2:{ 

				 boolean f_escriure = false;
				 
				 do {
				 
				 User u = CrearUsuario();
				 
				 if(!lista.getUsuarios().contains(u)&&u!=null){
					 lista.getUsuarios().add(u);
				 }else if(lista.getUsuarios().contains(u)){
					 System.out.println("Aquest Usuari ja esta registrat");
				 }else{
					 f_escriure = true;
				 }
				 if(u != null){
					 lista.EscriureObjectes(lista.getUsuarios(),nomFitxer);
				 }

				 }while(!f_escriure);

				 break;
				 
			  }

			 case 4: finalitzar = true; break;

			 case 3:{

				 System.out.println("Usuario");
				 String usuario = teclat.next();

				 System.out.println("Nueva Contrasenya");
				 String pass = teclat.next();

				 changepass(usuario,pass);

				 break;
			 }

			 }

			 
		 }while(!finalitzar);
		 
	}
	



	public void changepass(String usu, String pass) {
		if(lista.getUsuarios().contains(new User(usu,pass))){
			int u = lista.getUsuarios().indexOf(new User(usu,pass));
			lista.getUsuarios().get(u).setPass(pass);
			System.out.println("contrasenya cambiada con exito");
			fitxer.Reescribir(lista.getUsuarios());
		}else{
			System.out.println("No se ha encontrado al usuario");
		}
	}
	
	public User CrearUsuario() {
		System.out.print("Usuario: ");
	 	String user = teclat.next();
	 	
 		System.out.print("Contrasenya: ");
 		String pass = teclat.next();

 		if(user.equals("x")){
 			return null;
		}
 		return new User(user,pass);
 		
 		
	}
	
	public void Menu() {
		 System.out.println("1.Llistar");
		 System.out.println("2.Escriure");
		 System.out.println("3.Cambiar contrasenya");
		 System.out.println("4.Salir");
	}
	
}
