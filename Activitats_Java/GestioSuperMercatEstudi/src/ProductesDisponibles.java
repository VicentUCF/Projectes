import java.util.ArrayList;
import java.util.Iterator;

public class ProductesDisponibles implements Iterable {
    ArrayList<Producte> productes = new ArrayList<>();
    private int posicio = 0;
    @Override
    public Iterator iterator() {

        return new Iterator() {



            @Override
            public boolean hasNext() {
                return posicio < productes.size();
            }

            @Override
            public Producte next() {
                return productes.get(posicio++);
            }

            @Override
            public void remove(){
                int eliminar = posicio-1;
                if (eliminar<0){
                    return;
                }
                if (eliminar < productes.size()){
                    System.arraycopy(productes,eliminar,productes,eliminar,productes.size() -1 );
                }
            }

        };
    }

    public void add(Producte p ){

        if (productes.size()>0) {
            for (Producte a : productes) {
                if (a.compareTo(p) == 0) {
                    System.out.println("Aquesta id ja esta asociada a un producte");
                } else {
                    productes.add(p);
                    return;
                }
            }
        }else{
            productes.add(p);
        }


    }

    public void ListarProductes(){
        while (iterator().hasNext()){
            System.out.println(iterator().next());
        }
    }

    public void venderProduct(Producte p){
        while (iterator().hasNext()){
            System.out.println(iterator().next().getClass());
        }
    }


    @Override
    public String toString() {
        String res = "";
        for (Producte p : productes) {
            res += p.toString() + "\n";
        }
        res += "\b";

        return res;
    }
}
