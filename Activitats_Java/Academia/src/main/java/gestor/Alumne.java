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
public class Alumne {
    
    private String dni;
    private String nom;
    private Curs[] cursos;

    public Alumne(String dni, String nom) {
        this.dni = dni;
        this.nom = nom;
    }

    public Alumne(String dni, String nom, Curs[] cursos) {
        this.dni = dni;
        this.nom = nom;
        this.cursos = cursos;
    }
    
    
    public boolean equals(Object alumne){
    return dni.equals(((Alumne)alumne).getDni());
    }
    
    public ProvaEscrita ferExamen(Examen examen){
        
        ProvaEscrita prov = new ProvaEscrita(examen,this);
        examen.addProvaEscrita(prov);
        System.out.println(nom + " Ha fet un examen de "+ examen.getCurs().getNom() + " del " + examen.getTrimestre() + "r trimestre" );
        return prov;
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

    public Curs[] getCursos() {
        return cursos;
    }

    public void setCursos(Curs[] cursos) {
        this.cursos = cursos;
    }
    
    
    
}
