import java.io.Serializable;
import java.util.Objects;

public class Propietari implements Serializable {
    private String nom;

    public Propietari(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Propietari that = (Propietari) o;
        return Objects.equals(nom, that.nom);
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
