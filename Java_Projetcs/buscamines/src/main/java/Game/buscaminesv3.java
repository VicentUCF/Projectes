/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;




import java.util.Scanner;



public class buscaminesv3 {
    
    static Scanner teclat = new Scanner(System.in);
    static String Game[][];
    static String Tablero[][];
    static String Tab_boss[][];

   
    static int Random_Num(int max, int min){
        
        double numero = (Math.random()*max+min);
        int n_rand = (int)numero;
        
        return n_rand;
    }
    
    //inicialitza matrius - demana mines i les posa
    static void minar(){


        int dim;//dimensio del tauler

        System.out.print("Tamany del mapa: ");
         dim = teclat.nextInt();
 
         if(dim<10){dim = 10;}

        Game = new String[dim][dim];
        Tablero = new String[dim][dim];
        Tab_boss = new String [dim][dim];
            
        for (int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                    Game[i][j]="|_|";
                    Tablero[i][j]="|X|";
                    
            }
        }
        
        
        int mines;//cuantitat de mines
        
        System.out.print("Numero de bombas: ");
            mines = teclat.nextInt();
        
        int bomba_y;//coordenadas bomba y
        int bomba_x;//coordenadas bomba x
        int cont_mines = 0;
        do{
            bomba_y = Random_Num(dim,0);
            bomba_x = Random_Num(dim,0);
            if (!"|M|".equals(Game[bomba_y][bomba_x])) {

                Game[bomba_y][bomba_x]="|M|";
                cont_mines++;
            }
        }while(cont_mines<mines);
        
        
    }
    //si hi ha mina o no tambe comproba que la pos siga correcta
    static boolean minat(int y, int x){

        boolean mina=false;
        if(incorrecte(y,x)==false){
            if(Game[y][x]=="|M|"){
                mina = true;
            }else{
                mina = false;
            }
        }
    
        return mina;
    }
    
    //Si la posiciÃ³ Ã©s correcta o no
    static boolean incorrecte (int y, int x){
        boolean incorrecte=true;
        if (y>Tablero.length||y<0){
            incorrecte = true;
        }else if(x>Tablero.length||x<0){
            incorrecte = true;
        }else{
            incorrecte = false;
        }
        return incorrecte;
    }
    //Quantitat de mines adjacents dâ€™eixa posiciÃ³
    static int qma(int y, int x){
        int mines=0;

            if(incorrecte(y+1, x)==false){
                System.out.println(incorrecte(y+1, x));
                if(Tablero[y][x]=="|M|"){
                    mines++;
                }
            }else if(incorrecte(y-1, x)==false){
                if(Tablero[y][x]=="|M|"){
                    mines++;
                }
            }else if(incorrecte(y, x+1)==false){
                if(Tablero[y][x]=="|M|"){
                    mines++;
                }
            }else if(incorrecte(y, x-1)==false){
                if(Tablero[y][x]=="|M|"){
                    mines++;
                }
            }else if(incorrecte(y+1,x-1)==false){
                if(Tablero[y][x]=="|M|"){
                    mines++;
                }
            }else if(incorrecte(y-1,x+1)==false){
                if(Tablero[y][x]=="|M|"){
                    mines++;
                }
            }else if(incorrecte(y+1,x+1)==false){
                if(Tablero[y][x+1]=="|M|"){
                    mines++;
                }
            }else if(incorrecte(y-1,x-1)==false){
                if(Tablero[y][x]=="|M|"){
                    mines++;
                }
            }
           
        return mines;
    
    }
    //Si la posiciÃ³ estÃ  destapada o no
    static boolean destapat(int y, int x ){
    
        boolean destapat;

        if (Tablero[y][x]=="|_|"){
            destapat = true;
        }else{
            destapat = false;
        }
        
        return destapat;
        
    }
    //Quantitat de celÂ·les destapades que hi ha.
    static boolean qdestapats(){
        boolean finaljoc = false;
        int qdestapats=0;
        int mines=0;
      
        for (int i=0;i<(Tablero.length);i++){
            for(int j=0;j<(Tablero.length);j++){
                    if(Game[i][j]=="|M|"){
                        mines++;
                    }else if(Tablero[i][j]=="|_|"){
                        qdestapats++;
                    }
            }
        }

        if((qdestapats-mines)==Tablero.length){
            finaljoc = true;
        }else{
            finaljoc = false;
        }
        

        return finaljoc;
    }
    //Mostrar tauler 
    static void mostrarTauler(){

        for (int i=0;i<(Tablero.length);i++){
            for(int j=0;j<(Tablero.length);j++){
                System.out.print(Tablero[i][j]);    
            }
            System.out.println();
        }

        for (int i=0;i<Tablero.length;i++){
            for(int j=0;j<Tablero.length;j++){
                System.out.print(Game[i][j]);    
            }
            System.out.println();
        }


    
    }
    //si no hi ha mina crida a destapar();
    static void picar(int y, int x){
       
            if (minat(y,x)==false && destapat(y, x)==false){
                destapar(y,x);
            }
        
        

    
    }
    //va destapant el tabler
    static void destapar(int y, int x){
        if(qma(y,x) == 0){
            mostrarTauler();
            Tablero[y][x] = "|_|";
            if(incorrecte(y+1, x)==false){
                
                picar(y, x);
                
            }else if(incorrecte(y-1, x)==false){
                picar(y-1,x);
            }else if(incorrecte(y, x+1)==false){
                picar(y,x+1);
            }else if(incorrecte(y, x-1)==false){
                picar(y,x-1);
            }else if(incorrecte(y+1,x-1)==false){
                picar(y+1,x-1);
            }else if(incorrecte(y-1,x+1)==false){
                picar(y-1,x+1);
            }else if(incorrecte(y+1,x+1)==false){
                picar(y+1,x+1);
            }else if(incorrecte(y-1,x-1)==false){
                picar(y-1,x-1);
            }
            
        }else{
            Tablero[y][x]= "|"+ qma(y, x) + "|";
        }
    }
    
    
    
    
    public static void main(String[] args) {
         int x;
        int y;

        minar();
        mostrarTauler();
        do{
            System.out.println("PosiciÃ³ y: ");
                y = teclat.nextInt();
            System.out.println("PosiciÃ³ x: ");
                x = teclat.nextInt();

            picar(y,x);
            
        }while(qdestapats()==false);
    }
    
}
