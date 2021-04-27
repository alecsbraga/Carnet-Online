package Servicii;

import Obiecte.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CitireElevi {
    private static CitireElevi read;
    public CitireElevi() {
    }

    public static CitireElevi getInstance(){
        if(read == null)
            read = new CitireElevi();
        return read;
    }

    public void citire(String path, Elev[] elevi, ArrayList<Materie> materii, int[][] note, int[][] absente, ArrayList<Concursuri> concursuri, int n) {
        try {
            Scanner in = new Scanner(new File(path));
            String linie;
            in.nextLine();
            for (int i = 0; i < n; i++) {
                linie = in.nextLine();
                String[] aux = linie.split(", ");
                if(!aux[5].equals("-") && !aux[6].equals("-")) {
                    elevi[i] = new Elev(aux[0], aux[1], aux[2], materii, note[Integer.parseInt(aux[3])], absente[Integer.parseInt(aux[4])], concursuri.get(Integer.parseInt(aux[5])), Integer.parseInt(aux[6]));
                }
                else{
                    elevi[i] = new Elev(aux[0], aux[1], aux[2], materii, note[Integer.parseInt(aux[3])], absente[Integer.parseInt(aux[4])]);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
