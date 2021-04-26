package com.company;

import Menu.MainMenu;
import Obiecte.*;
import Servicii.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Initializari

        CitireProfesori read0 = CitireProfesori.getInstance();
        Profesor[] profesori = new Profesor[10];
        read0.citire("src\\Fisiere\\Profesori.csv", profesori, 10);

        CitireConcursuri read1 = CitireConcursuri.getInstance();
        ArrayList<Concursuri> concursuri = new ArrayList<>(3);
        read1.citire("src\\Fisiere\\Concursuri.csv", concursuri, 3);

        CitireDiriginti read2 = CitireDiriginti.getInstance();
        Diriginte[] diriginti = new Diriginte[4];
        read2.citire("src\\Fisiere\\Diriginti.csv", diriginti, 4);

        CitireMaterii read3 = CitireMaterii.getInstance();
        ArrayList<Materie> materii = new ArrayList<>(14);
        read3.citire("src\\Fisiere\\Materii.csv", materii, profesori, diriginti, 14);

        int[][] note = new int[40][14];
        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                note[i][j]= ThreadLocalRandom.current().nextInt(4,  10);
            }
        }

        int[][] absente = new int[40][14];
        for(int i=0; i<40; ++i) {
            for (int j = 0; j < 14; ++j){
                absente[i][j]= ThreadLocalRandom.current().nextInt(0,  4);
            }
        }

        CitireElevi read4 = CitireElevi.getInstance();
        Elev[] elevi = new Elev[40];
        read4.citire("src\\Fisiere\\Elevi.csv", elevi, materii, note, absente, concursuri,40);

        Elev[] elevi1 = Arrays.copyOfRange(elevi,0,10);
        Elev[] elevi2 = Arrays.copyOfRange(elevi,10,20);
        Elev[] elevi3 = Arrays.copyOfRange(elevi,20,30);
        Elev[] elevi4 = Arrays.copyOfRange(elevi,30,40);

        Clasa clasa1 = new Clasa("a XII-a A",elevi1,diriginti[0],"Matematica-Informatica");
        Clasa clasa2 = new Clasa("a XII-a B",elevi2,diriginti[1],"Matematica-Informatica");
        Clasa clasa3 = new Clasa("a XII-a A",elevi3,diriginti[2],"Filologie");
        Clasa clasa4 = new Clasa("a XII-a B",elevi4,diriginti[3],"Filologie");

        Clasa[] clase1={clasa1,clasa2};
        Clasa[] clase2={clasa3,clasa4};

        Director director1= new Director("Parghel","Ion");
        Director director2= new Director("Zaharia","Dan");

        Liceu liceu1 = new Liceu("Dinicu Golescu",director1,clase1);
        Liceu liceu2 = new Liceu("Dan Barbilian",director2,clase2);

        //Apeluri pentru cele 12 actiunii sau meniul interctiv
        MainMenu menu =  new MainMenu();
        menu.apelare(liceu1, liceu2, clasa1, clasa2, clasa3, clasa4, elevi);
    }
}
