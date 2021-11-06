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
public class Academia {
    private Alumne[] alumnes;
    private Profesor[] profes;
    private Curs[] cursos;
    private Becari[] becaris;

    public Academia(int cantAlumnes,int cantProfes, int cantCursos, int cantBecaris) {
        this.alumnes =  new Alumne[cantAlumnes];
        this.profes =  new Profesor[cantProfes];
        this.cursos = new Curs[cantCursos];
        this.becaris = new Becari[cantBecaris];
    }
   
    public void MatricularAlumne(Curs curs,Alumne alumne){
        
        boolean introduit = false;
        for (int i = 0; i < alumnes.length&& !introduit; i++) {
            if (alumnes[i]==null) {
                alumnes[i]=alumne;
                introduit=true;
            }
        }
        
        introduit=false;
        for (int i = 0; i < curs.getAlumnes().length && !introduit; i++) {
            if (curs.getAlumnes()[i]==null) {
                curs.getAlumnes()[i]=alumne;
                introduit = true;
            }
        }
        if (introduit) {
            System.out.println("Alumne introduit amb exit al curs "+ curs.getNom());
        }else{
              System.out.println("AQUEST CURS ESTA PLE");
        }
        
    }
    
    public void asignarProfesor(Curs curs,Profesor profe){
        
        boolean introduit = false;
        for (int i = 0; i < profes.length&& !introduit; i++) {
            if (profes[i]==null) {
                profes[i]=profe;
                introduit=true;
            }
        }
        
         introduit = false;
        for (int i = 0; i < curs.getProfesors().length && !introduit; i++) {
            if (curs.getProfesors()[i]==null) {
                curs.getProfesors()[i]=profe;
                introduit = true;
            }
        }
        if (introduit) {
            System.out.println("Profesor introduit amb exit al curs "+ curs.getNom());
        }else{
              System.out.println("AQUEST CURS JA HI TE UN PROFESOR");
        }
    }
    
    public void asignarBecari(Curs curs,Becari becari){
        
        boolean introduit = false;
        for (int i = 0; i < becaris.length&& !introduit; i++) {
            if (becaris[i]==null) {
                becaris[i]=becari;
                introduit=true;
            }
        }
        
         introduit = false;
        for (int i = 0; i < curs.getBecaris().length && !introduit; i++) {
            if (curs.getBecaris()[i]==null) {
                curs.getBecaris()[i]=becari;
                introduit = true;
            }
        }
        if (introduit) {
            System.out.println("Becari introduit amb exit al curs "+ curs.getNom());
        }
    }
    
    
    public void LlistarProfesors(){
    for (int i = 0; i < profes.length; i++) {
            if (profes[i]!=null) {
                System.out.println("Nom: "+profes[i].getNom()+" DNI: "+profes[i].getDni() );
                 }
           }
    }
    
    public void LlistarAlumnes(){
     for (int i = 0; i < alumnes.length; i++) {
            if (alumnes[i]!=null) {
                System.out.println("Nom: "+alumnes[i].getNom()+" DNI: "+alumnes[i].getDni() );
            }
        }
    }
    
    
    public void LlistarCursos(){
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i]!=null) {
                System.out.println("Nom curs: "+cursos[i].getNom());
            }
        }
    
    }
    
    
    public void LlistarBecaris(){
        for (int i = 0; i < becaris.length; i++) {
            if (becaris[i]!=null) {
                System.out.println("Nom: "+becaris[i].getNom()+" DNI: "+becaris[i].getDni());
            }
        }
    
    }
    
    
    public void anyadirCurs(Curs curs){
        boolean introduit = false;
        for (int i = 0; i < cursos.length&& !introduit; i++) {
            if (cursos[i]==null) {
                cursos[i]=curs;
                introduit = true;
            }
        }
        if (introduit) {
            System.out.println("S'ha introduit el nou curs "+ curs.getNom());
        }
    }

    public Alumne[] getAlumnes() {
        return alumnes;
    }

    public void setAlumnes(Alumne[] alumnes) {
        this.alumnes = alumnes;
    }

    public Profesor[] getProfes() {
        return profes;
    }

    public void setProfes(Profesor[] profes) {
        this.profes = profes;
    }

    public Curs[] getCursos() {
        return cursos;
    }

    public void setCursos(Curs[] cursos) {
        this.cursos = cursos;
    }
    
    
}
