package Servicii;

import Obiecte.Diriginte;
import Obiecte.Materie;
import Obiecte.Profesor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CitireMaterii {
    private static CitireMaterii read;
    public CitireMaterii() {
    }

    public static CitireMaterii getInstance(){
        if(read == null)
            read = new CitireMaterii();
        return read;
    }

    public void citire(String path, ArrayList<Materie> materii, Profesor[] profesori, Diriginte[] diriginti, int n) {
        try {
            Scanner in = new Scanner(new File(path));
            String linie;
            in.nextLine();
            for (int i = 0; i < n; i++) {
            linie = in.nextLine();
            String[] aux = linie.split(", ");
            int index = Integer.parseInt(aux[1]);
            Materie materie;
            if(i <= 9){
                materie = new Materie(aux[0], profesori[index]);
            }
            else{
                materie = new Materie(aux[0], diriginti[index]);
            }
            materii.add(materie);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
