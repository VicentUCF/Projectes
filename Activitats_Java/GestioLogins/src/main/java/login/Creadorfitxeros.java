package login;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Creadorfitxeros {
	
	private String nom;
	private File f;
	
	public Creadorfitxeros(String nom) {
		this.nom = nom;
		
		  this.f = new File(nom);
		
		  
		 if(!f.exists()) {
			 try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 System.out.println("S'ha creat el fitxer "+ nom);
		 }else {
			 
			 System.out.println("El fitxer ja existia");
		 }
	}
 
	 public void Llistar() {

		 try {
		 		BufferedReader buffer = new BufferedReader(new FileReader(f));
		 		while(buffer.ready()) {
		 			System.out.println(buffer.readLine());
		 		}
		 		buffer.close();
		 	} catch (IOException e) {

		 		e.printStackTrace();
		 	}


 	}
 
	 public void EscriureAlFitxer(String usr,String pass) {

		 try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("Logins",true));
			
				bw.write(usr + " " + pass);
				bw.newLine();
				bw.close();

		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 
 }




	
	 public void Reescribir (ArrayList <User> usuarios){

		 try (BufferedWriter bw = new BufferedWriter(new FileWriter("Logins"))) {
		 	bw.write("");
		 } catch (IOException e){
		 	e.printStackTrace();
		 }

		 for(int i=0;i<usuarios.size();i++){
			EscriureAlFitxer(usuarios.get(i).getUser(),usuarios.get(i).getPass());
		 }

	 }


	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	@Override
	public String toString() {
		return "Creadorfitxeros [nom=" + nom + "]";
	}
	
	
	
	
}
