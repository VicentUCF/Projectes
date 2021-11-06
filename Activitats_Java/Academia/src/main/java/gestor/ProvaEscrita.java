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
public class ProvaEscrita {
    private Examen examen;
    private Alumne alumne;
    private int nota;
    private Becari corrector;

    public ProvaEscrita(Examen examen, Alumne alumne) {
        this.examen = examen;
        this.alumne = alumne;
        this.corrector = examen.getCurs().getCorrector();
    }

    
    
    public ProvaEscrita(Examen examen, Alumne alumne, int nota, Becari corrector) {
        this.examen = examen;
        this.alumne = alumne;
        this.nota = nota;
        this.corrector = corrector;
    }

    @Override
    public boolean equals(Object prv){
    return alumne.equals(((ProvaEscrita)prv).getAlumne());
    }
    
    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Alumne getAlumne() {
        return alumne;
    }

    public void setAlumne(Alumne alumne) {
        this.alumne = alumne;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Becari getCorrector() {
        return corrector;
    }

    public void setCorrector(Becari corrector) {
        this.corrector = corrector;
    }
    
    
    
    
}
