package login;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaUsuarios {
	
	private ArrayList<User> usuarios;
	
	
	public ListaUsuarios(File f) {

			this.usuarios = CarregarUsuaris(f);
	}

	public ListaUsuarios() {

		this.usuarios = new ArrayList();
	}




	public ArrayList<User> CarregarLlista(File f) {

		ArrayList<User> lista = new ArrayList();
		 try {

			Scanner teclat = new Scanner(f);
			
			do {
			
			String usu = teclat.next();
			String pass = teclat.next();

			if(!lista.contains(new User(usu,pass))) {
				lista.add(new User(usu,pass));
			}
			
			}while(teclat.hasNext());
			
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		return lista;
	}

	public void EscriureObjectes(ArrayList <User> usuarios,String fitxer){

		try {
			FileOutputStream fos =new FileOutputStream(fitxer);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(usuarios);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public ArrayList<User> CarregarUsuaris(File f){

		ArrayList<User> usuarios = new ArrayList();

		try {
			FileInputStream fis = new FileInputStream(f.getName());
			ObjectInputStream ois = new ObjectInputStream(fis);

			usuarios = (ArrayList<User>) ois.readObject();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return usuarios;
	}
	
	
	public void ListarUsuarios() {
		
		for(User u : usuarios) {
			System.out.println(u);
		}
		
	}
	
	
	public ArrayList<User> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(ArrayList<User> usuarios) {
		this.usuarios = usuarios;
	}


}
