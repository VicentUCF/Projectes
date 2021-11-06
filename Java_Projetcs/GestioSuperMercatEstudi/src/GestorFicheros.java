package Files;

import java.io.*;

public class GestorFicheros {

    public void crearFitxer(File f){//No faria falta gastarse
        if (!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean existixElFitxer(File f){

        return f.exists();

    }

    public void llegirDocument(File f){

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(f));
            while(buffer.ready()) {
                System.out.println(buffer.readLine());
            }
            buffer.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void escriureAlDocument(File f, String s){//Si no existix el document el crea automaticament

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(f.getAbsolutePath(),true));

            bw.write(s);
            bw.newLine();
            bw.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void escriureAlDocument(File f, Object o){

        f.mkdirs();

        try {
            FileOutputStream fos = new FileOutputStream(f.getAbsolutePath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object carregarInformacio(File f){
        try {
            FileInputStream fis = new FileInputStream(f.getAbsolutePath());
            ObjectInputStream ois = new ObjectInputStream(fis);

            return ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean borrarFitxer(File f){
        if (existixElFitxer(f)) {
            return f.delete();
        }
        return false;
    }


}

