public class Supermercat {
    public static void main(String[] args) {

        ProductesDisponibles productes = new ProductesDisponibles();

        productes.add(new Producte(2,30,"rosquilletes"));
        productes.add(new Producte(1,23,"danonino"));
        productes.add(new Producte(1,12,"llet"));
        productes.add(new Producte(6,32,"arros"));


       productes.ListarProductes();
       productes.venderProduct(new Producte(2,30,"rosquilletes"));


    }
}
