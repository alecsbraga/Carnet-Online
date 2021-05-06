package Servicii;

import Obiecte.Concursuri;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CitireConcursuri {
    private static CitireConcursuri read;
    private CitireConcursuri() {
    }

    public static CitireConcursuri getInstance(){
        if(read == null)
            read = new CitireConcursuri();
        return read;
    }

    public void citire(String path, ArrayList<Concursuri> concursuri, int n) {
        try {
            Scanner in = new Scanner(new File(path));
            String linie;
            in.nextLine();
            for (int i = 0; i < n; i++) {
                linie = in.nextLine();
                String[] aux = linie.split(", ");
                Concursuri concurs = new Concursuri(aux[0], aux[1], aux[2]);
                concursuri.add(concurs);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
