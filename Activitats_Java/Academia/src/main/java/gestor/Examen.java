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
public class Examen {
    private Curs curs;
    private int trimestre;
    private  ProvaEscrita[] prova = new ProvaEscrita[10];

    public Examen(Curs curs, int trimestre) {
        this.curs = curs;
        this.trimestre = trimestre;
    }
    
     public void addProvaEscrita(ProvaEscrita prv){
         boolean introduit = false;
         for (int i = 0; i < prova.length&&!introduit; i++) {
             if (prova[i]==null) {
                 prova[i]=prv;
                 introduit = true;
             }
         }
     }
     
     public void addNotaProva(ProvaEscrita prv,int nota){
         boolean introduit = false;
         for (int i = 0; i < prova.length&&!introduit; i++) {
             if (prova[i].equals(prv)) {
                 prova[i].setNota(nota);
                 introduit = true;
             }
         }
   }
     
    
    public double getNotaMitja(){
        int notaMitja = 0;
        int provesFetes = 0;
        
        
        
        for (int i = 0; i < prova.length; i++) {
            if (prova[i]!=null) {
                provesFetes++;
                notaMitja= notaMitja + prova[i].getNota();
            }
        }
        
        
        
        return notaMitja/provesFetes;
        
        
    }
    
    public Alumne[] getSuspensos(){
        
        boolean introduit=false;
        Alumne[] suspesos = new Alumne[prova.length];
        
         for (int i = 0; i < prova.length; i++) {
            if (prova[i]!=null && prova[i].getNota()<5) {
                for (int j = 0; j < prova.length&&!introduit; j++) {
                    if (suspesos[j]==null) {
                         suspesos[j]=prova[i].getAlumne();
                         introduit=true;
                    }
                   
                }
               
            }
             introduit=false;
        }
    
    return suspesos;
    }
        
    
    public Alumne[] getAprobats(){
        boolean introduit=false;
        Alumne[] aprobats = new Alumne[prova.length];
        
         for (int i = 0; i < prova.length; i++) {
            if (prova[i]!=null && prova[i].getNota()>=5) {
                for (int j = 0; j < prova.length&&!introduit; j++) {
                    if (aprobats[j]==null) {
                         aprobats[j]=prova[i].getAlumne();
                         introduit=true;
                    }
                   
                }
               
            }
             introduit=false;
        }
    
    return aprobats;
    }
    

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public ProvaEscrita[] getProva() {
        return prova;
    }

    public void setProva(ProvaEscrita[] prova) {
        this.prova = prova;
    }
    
    
    
    
    
    
    
}
