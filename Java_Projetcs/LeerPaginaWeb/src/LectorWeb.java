import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class LectorWeb {

    public void Lector(){
        
        ArrayList<Targeta> graficas = new ArrayList();
        
        try {
            // Se abre la conexión
            URL url = new URL("https://www.appinformatica.com/componentes/tarjetas-graficas/");
            URLConnection conexion = url.openConnection();
            conexion.connect();

            // Lectura
            InputStream is = conexion.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            
            ArrayList<String> grafiques = new ArrayList();

            while (br.readLine() != null) {

              String  g = br.readLine();

              if (g != null && g.contains("title")){
                  g = g.substring(g.indexOf("title"));
              }
                grafiques.add(g);


            }

            for (String s: grafiques
                 ) {
                System.out.println(s);
            }



            


            br.close();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
       }

    }
    
    



}