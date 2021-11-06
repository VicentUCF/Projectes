public class Producte  implements  Comparable<Producte>{

    private int id;
    private int preu;
    private String descripcio;

    public Producte(int id, int preu, String descripcio) {
        this.id = id;
        this.preu = preu;
        this.descripcio = descripcio;
    }

    @Override
    public int compareTo(Producte p) {
        return this.id - p.id;
    }


    @Override
    public String toString() {
        return "Producte{" +
                "id=" + id +
                ", preu=" + preu +
                ", descripcio='" + descripcio + '\'' +
                '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreu() {
        return preu;
    }

    public void setPreu(int preu) {
        this.preu = preu;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }


}
