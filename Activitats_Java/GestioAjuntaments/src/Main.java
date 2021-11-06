import java.io.File;

public class Main {
    public static void main(String[] args) {
        File f = new File("/home/vicent_ucf/vehiculos");
        Ajuntament favara = new Ajuntament("Favara",f);
        for (Vehicle v:favara.getVehicles()) {
            System.out.println(v.getMatricula());
        }
        Propietari prop1 = new Propietari("Vicent");
        Propietari prop2 = new Propietari("Paco");
        Propietari prop3 = new  Propietari("Jesus");

        Coche coche1 = new Coche("4532F",4,prop1);
        Coche coche2 = new Coche("5331Q",4,prop2);
        Moto moto1 = new Moto("6312R",prop3);



        favara.AddVehicle(coche1);
        favara.AddVehicle(coche2);
        favara.AddVehicle(moto1);

        //favara.EscriureVehicles(favara.getVehicles(),f);
    }
}
