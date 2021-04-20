package com.company;

import Obiecte.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Profesor[] profesori = null;
        try {
            Scanner in = new Scanner(new File( "src\\Fisiere\\Profesori.csv"));
            int n = in.nextInt();
            in.nextLine();
            profesori = new Profesor[n];
            String linie;

            for (int i = 0; i < n; i++) {
                linie = in.nextLine();
                String[] aux = linie.split(", ");
                profesori[i]= new Profesor(aux[0], aux[1]);
            }

        } catch ( FileNotFoundException e){
            e.printStackTrace();
        }



        Diriginte[] diriginti = null;
        try {
            Scanner in = new Scanner(new File( "src\\Fisiere\\Diriginti.csv"));
            int n = in.nextInt();
            in.nextLine();
            diriginti = new Diriginte[n];
            String linie;

            for (int i = 0; i < n; i++) {
                linie = in.nextLine();
                String[] aux = linie.split(", ");
                diriginti[i]= new Diriginte(aux[0], aux[1]);
            }

        } catch ( FileNotFoundException e){
            e.printStackTrace();
        }

        ArrayList<Materie> materii = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File( "src\\Fisiere\\Materii.csv"));
            int n = in.nextInt();
            in.nextLine();
            String linie;

            for (int i = 0; i < n; i++) {
                linie = in.nextLine();
                String[] aux = linie.split(", ");
                int index = Integer.parseInt(aux[1]);
                if(i <= 9){
                    assert profesori != null;
                    Materie materie = new Materie(aux[0], profesori[index]);
                    materii.add(materie);
                }
                else{
                    assert diriginti != null;
                    Materie materie = new Materie(aux[0], diriginti[index]);
                    materii.add(materie);
                }
            }

        } catch ( FileNotFoundException e){
            e.printStackTrace();
        }

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

        Director director1= new Director("Parghel","Ion");
        Director director2= new Director("Zaharia","Dan");

        ArrayList<Concursuri> concursuri = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File( "src\\Fisiere\\Concursuri.csv"));
            int n = in.nextInt();
            in.nextLine();
            String linie;

            for (int i = 0; i < n; i++) {
                linie = in.nextLine();
                String[] aux = linie.split(", ");
                Concursuri concurs = new Concursuri(aux[0], aux[1], aux[2]);
                concursuri.add(concurs);

            }

        } catch ( FileNotFoundException e){
            e.printStackTrace();
        }

        Elev[] elevi = null;
        try {
            Scanner in = new Scanner(new File( "src\\Fisiere\\Elevi.csv"));
            int n = in.nextInt();
            in.nextLine();
            elevi = new Elev[n];
            String linie;

            for (int i = 0; i < n; i++) {
                linie = in.nextLine();
                String[] aux = linie.split(", ");
                if(aux.length == 7) {
                    elevi[i] = new Elev(aux[0], aux[1], aux[2], materii, note[Integer.parseInt(aux[3])], absente[Integer.parseInt(aux[4])], concursuri.get(Integer.parseInt(aux[5])), Integer.parseInt(aux[6]));
                }
                else{
                    elevi[i] = new Elev(aux[0], aux[1], aux[2], materii, note[Integer.parseInt(aux[3])], absente[Integer.parseInt(aux[4])]);
                }

            }

        } catch ( FileNotFoundException e){
            e.printStackTrace();
        }

        assert elevi != null;
        Elev[] elevi1 = Arrays.copyOfRange(elevi,0,10);
        Elev[] elevi2 = Arrays.copyOfRange(elevi,10,20);
        Elev[] elevi3 = Arrays.copyOfRange(elevi,20,30);
        Elev[] elevi4 = Arrays.copyOfRange(elevi,30,40);

        assert diriginti != null;
        Clasa clasa1 = new Clasa("a XII-a A",elevi1,diriginti[0],"Matematica-Informatica");
        Clasa clasa2 = new Clasa("a XII-a B",elevi2,diriginti[1],"Matematica-Informatica");
        Clasa clasa3 = new Clasa("a XII-a A",elevi3,diriginti[2],"Filologie");
        Clasa clasa4 = new Clasa("a XII-a B",elevi4,diriginti[3],"Filologie");

        Clasa[] clase1={clasa1,clasa2};
        Clasa[] clase2={clasa3,clasa4};

        Liceu liceu1 = new Liceu("Dinicu Golescu",director1,clase1);
        Liceu liceu2 = new Liceu("Dan Barbilian",director2,clase2);

        //Apeluri pentru cele 12 actiunii

        //1.media notelor unui liceu
        System.out.println("Medie liceului Dinicu Golescu este : "+liceu2.mediaPeLiceu());
        System.out.println();

        //2.cea mai mare medie dintr-o clasa
        System.out.println("Cea mai mare medie din "+clasa1.getDenumire() +": "+ clasa1.ceaMaiMareMedieClasa());
        System.out.println();

        //3.cea mai mare medie dintr-un liceu
        System.out.println("Cea mai mare medie din "+liceu2.getDenumire_liceu()+" :"+liceu2.ceaMaiMareMedieLiceu());
        System.out.println();

        //4.numarul total de absente ale unui elev
        System.out.println("Numarul total de absente ale elevului "+ elevi[0].getNume()+" "+elevi[0].getPrenume()+" sunt: "+elevi[0].absenteElev());
        System.out.println();

        //5.top n cei mai buni elevi dintr-o clasa
        clasa1.ceiMaiBuniElevi(4); // top 4 cei mai buni elevi dintr-o clasa
        System.out.println();

        //6.top n cei mai buni elevi dintr-un liceu
        liceu2.ceiMaiBuniElevi(4);
        System.out.println();

        //7.cel mai chiulangiu elevi dintr-un liceu
        System.out.println("Cel mai chiulangiu elev din liceul "+ liceu1.getDenumire_liceu()+ ", este " + liceu1.celMaiCiulangiu(liceu1).getNume()+" "+ liceu1.celMaiCiulangiu(liceu1).getPrenume()+", avand  "+liceu1.celMaiCiulangiu(liceu1).absenteElev()+" absente");
        System.out.println();

        //8.afisare elevi corigenti dintr-un liceu
        liceu2.corigentii(liceu2);
        System.out.println();

        //9.pentru o clasa se va afisa dirigintele, numarul de elevi, media si numarul total de absente
        clasa1.detaliiClasa();
        System.out.println();

        //10.situatia unui elev dupa nume
        elevi[0].Afisare();
        System.out.println();

        //11.afisare  elevi olimpici dintr-un liceu (care e in top3 la un concurs)
        liceu1.eleviOlimpici();
        System.out.println();

        //12.se va afisa toti elevii dintr-un liceu cu mediile pentru fiecare materie
        liceu1.afisare();
        System.out.println();
    }
}
