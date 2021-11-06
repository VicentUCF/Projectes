import java.io.*;
import java.util.ArrayList;

public class Ajuntament {
    private String poblacio;
    private ArrayList<Vehicle> vehicles;

    public Ajuntament(String poblacio,File f) {
        this.poblacio = poblacio;
        if (f.length() == 0){
            this.vehicles = new ArrayList();
        }else{
            this.vehicles = CarregarVehicles(f);
        }
    }

    public void AddVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void EscriureVehicles(ArrayList <Vehicle> vehicles,File f){

        try {
            FileOutputStream fos =new FileOutputStream(f.getAbsolutePath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(vehicles);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Vehicle> CarregarVehicles(File f){

        ArrayList<Vehicle> vehicles = new ArrayList();

        try {
            FileInputStream fis = new FileInputStream(f.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);

            vehicles = (ArrayList<Vehicle>) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
