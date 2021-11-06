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
public class Becari {
     protected String dni;
    protected String nom;
    protected Curs curs;
    private int anyComensament;

    public Becari(String dni, String nom) {
        this.dni = dni;
        this.nom = nom;
    }

    public Becari(String dni, String nom, Curs curs, int anyComensament) {
        this.dni = dni;
        this.nom = nom;
        this.curs = curs;
        this.anyComensament = anyComensament;
    }
    
   
    
     @Override
    public boolean equals(Object becari){
    return dni.equals(((Becari)becari).getDni());
    }
    
    public void CorregirProva(ProvaEscrita prova){
         int nota =   (int)(Math.random()*10);
         prova.getExamen().addNotaProva(prova, nota);
         System.out.println(nom + " Ha corregit un examen de "+ curs.getNom() + " de " + prova.getAlumne().getNom() + " del " + prova.getExamen().getTrimestre() + "r trimestre" );
         
        prova.setNota(nota);
        
    }
    public String getDni() { 
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    public int getAnyComensament() {
        return anyComensament;
    }

    public void setAnyComensament(int anyComensament) {
        this.anyComensament = anyComensament;
    }
    
    
    
}
