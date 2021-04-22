package Servicii;

import Obiecte.Profesor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CitireProfesori {
    private static CitireProfesori read;
    public CitireProfesori() {
    }

    public static CitireProfesori getInstance(){
        if(read == null)
            read = new CitireProfesori();
        return read;
    }

    public void citire(String path, Profesor[] profesori, int n) {
        try {
            Scanner in = new Scanner(new File(path));
            String linie;
            for (int i = 0; i < n; i++) {
                linie = in.nextLine();
                String[] aux = linie.split(", ");
                profesori[i] = new Profesor(aux[0], aux[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
