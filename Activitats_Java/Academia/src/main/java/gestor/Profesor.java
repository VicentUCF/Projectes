/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

/**
 *
 * @author VicentUCF
 */
public class Profesor extends Becari{
   
    private  final Curs[] cursos= new Curs[100];

    public Profesor(String dni, String nom) {
        super(dni, nom);
        
    }
    
    public Examen possarExamen(Curs curs,int trimestre){
        
        Examen ex = new Examen(curs,trimestre);
        curs.addExamen(ex, trimestre);
        System.out.println(nom + " Ha posat un examen de "+ curs.getNom() + " del " + trimestre + "r trimestre" );
        
        return ex;
    }
    public void getPercentageSuspesos(Curs curs){
    }
    public void getPercentageAprovats(Curs curs){
    }

    public Curs[] getCursos() {
        return cursos;
    }

  

    
    
}
