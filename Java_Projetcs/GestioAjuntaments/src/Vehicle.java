import java.io.Serializable;
import java.util.Objects;

public abstract class Vehicle implements Serializable {
    protected int numero_rodes;
    protected String matricula;
    protected Propietari propietari;


    public Vehicle(String matricula,int numero_rodes, Propietari propietari) {
        this.numero_rodes = numero_rodes;
        this.matricula = matricula;
        this.propietari = propietari;
    }

    public int getNumero_rodes() {
        return numero_rodes;
    }

    public void setNumero_rodes(int numero_rodes) {
        this.numero_rodes = numero_rodes;
    }

    public Propietari getPropietari() {
        return propietari;
    }

    public void setPropietari(Propietari propietari) {
        this.propietari = propietari;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(matricula, vehicle.matricula) && Objects.equals(propietari, vehicle.propietari);
    }

}
