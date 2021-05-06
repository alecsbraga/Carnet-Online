package Servicii;

import Obiecte.Diriginte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CitireDiriginti {
    private static CitireDiriginti read;
    private CitireDiriginti() {
    }

    public static CitireDiriginti getInstance(){
        if(read == null)
            read = new CitireDiriginti();
        return read;
    }

    public void citire(String path, Diriginte[] diriginti, int n) {
        try {
            Scanner in = new Scanner(new File(path));
            String linie;
            in.nextLine();
            for (int i = 0; i < n; i++) {
                linie = in.nextLine();
                String[] aux = linie.split(", ");
                diriginti[i]= new Diriginte(aux[0], aux[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
