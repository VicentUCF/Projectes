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
public class Gestor {
    public static void main(String[] args) {
        
        //Creacio Alumnes//
        Alumne Paco = new Alumne("234","Paco");
        Alumne Alberto = new Alumne("123","Alberto");
        Alumne Pablo = new Alumne("231","Pablo");
        Alumne Esteban = new Alumne("672","Esteban");
        //Final Alumnes
        
        //Creacio Professors
        Profesor Sebas = new Profesor("555","Sebas");
        Profesor Antonio = new Profesor("444","Antonio");
        Profesor Plamen = new Profesor("222","Plamen");
        Profesor Pekas = new Profesor("111","Pekas");
        Profesor Vicent = new Profesor("666","Vicent");
        //Final Professors 
        
        //Creacio Cursos
        Curs informatica = new Curs("informatica",2021,25,1,20);
        Curs SI = new Curs("SistemesInformatics",2021,25,1,20);
        //Final Cursos
        
        //Creacio Becaris
        Becari Pepe = new Becari("999","Pepe",informatica,2020);
        Becari Juan = new Becari("7532","Juan",informatica,2020);
        Becari Lorena = new Becari("953299","Lorena",informatica,2020);
        Becari Domingo = new Becari("2341123","Domingo",informatica,2020);
        Becari Aitor = new Becari("12313","Aitor",informatica,2020);
        //Final becaris
        
        
        //Creacio Academies
        Academia academia1 = new Academia(100,100,100,100);
        //Final Academies
        
     
        
        academia1.MatricularAlumne(informatica, Paco);
        academia1.asignarProfesor(informatica,Sebas);
        
        academia1.asignarBecari(informatica,Pepe);
        academia1.asignarBecari(informatica,Juan);
        academia1.asignarBecari(informatica,Lorena);
        academia1.asignarBecari(informatica,Aitor);
        academia1.asignarBecari(informatica,Domingo);
        
        academia1.anyadirCurs(informatica);
        academia1.LlistarAlumnes();
        academia1.LlistarProfesors();
        academia1.LlistarCursos();
        
        System.out.println("Alumnes Informatica");
        informatica.LlistarAlumnesCurs();
       
        System.out.println("Profesor Informatica");
        informatica.LlistarProfesorsCurs();
        
         System.out.println("Becaris informatica");
         informatica.LlistarBecarisCurs();
        
         
       
        
        
        
        //EXAMENS 1
        Examen ex = Sebas.possarExamen(informatica,0);
        ProvaEscrita prv = Paco.ferExamen(ex);
        ProvaEscrita prv1 = Alberto.ferExamen(ex);
        informatica.getCorrector().CorregirProva(prv);
        informatica.getCorrector().CorregirProva(prv1);
        //
        
         //EXAMENS 2
        Examen ex2 = Sebas.possarExamen(informatica,1);
        ProvaEscrita prv3 = Paco.ferExamen(ex2);
        ProvaEscrita prv4= Alberto.ferExamen(ex2);
        informatica.getCorrector().CorregirProva(prv3);
        informatica.getCorrector().CorregirProva(prv4);
        //
        
        System.out.println("Nota de "+prv1.getAlumne().getNom() + ": "+ prv1.getNota());
        System.out.println("Nota de "+prv4.getAlumne().getNom() + ": "+ prv4.getNota());
      
//        informatica.getAprovats(0);
//        informatica.getSuspesos(0);
      

//        System.out.println(ex.getSuspensos());
//        System.out.println(ex.getAprobats());
        System.out.println("Nota Mitja ex1 " + ex.getNotaMitja());
        System.out.println("Nota Mitja ex2 "+ex2.getNotaMitja());
        System.out.println("Nota Mitja Curs;"+informatica.getNotaMitja());
        informatica.getLlistarMitjes();
        System.out.println("Mitja del curs de alumne Alberto: "+informatica.getMitja(Alberto));
        
        
        
        
        
        
        for (int i = 0; i < informatica.getAprovats().length; i++) {
            if (informatica.getAprovats()[i]!=null) {
                System.out.println(informatica.getAprovats()[i].getNom());
            }
            
        }
        
    }
}
